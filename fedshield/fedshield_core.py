"""
FedShield Core — Federated GNN fraud detection with DP aggregation.
Used by app.py (Streamlit dashboard).
"""
import numpy as np
import torch
import torch.nn as nn
import torch.nn.functional as F
from sklearn.metrics import (accuracy_score, f1_score, roc_auc_score,
                             precision_score, recall_score)
import random

SEED = 42
np.random.seed(SEED); torch.manual_seed(SEED); random.seed(SEED)

# ---- Config ----
N_ACCOUNTS   = 1500
N_BANKS      = 3
N_RINGS      = 20
RING_SIZE    = (4, 10)
FRAUD_RATE   = 0.06
FEAT_DIM     = 8
HIDDEN       = 32
LOCAL_EPOCHS = 3
LR           = 0.01
DP_SIGMA     = 0.6
DP_CLIP      = 1.0


# ============================================================
# DATA GENERATION
# ============================================================
def normalize_adj(A):
    A = A + np.eye(A.shape[0], dtype=np.float32)
    d = A.sum(1)
    d_inv = 1.0 / np.sqrt(d + 1e-8)
    return (d_inv[:, None] * A) * d_inv[None, :]


def generate_data(seed=SEED, n_accounts=N_ACCOUNTS, n_banks=N_BANKS,
                  n_rings=N_RINGS, fraud_rate=FRAUD_RATE):
    rng = np.random.default_rng(seed)
    n = n_accounts
    X = np.zeros((n, FEAT_DIM), dtype=np.float32)
    X[:, 0] = rng.normal(45, 15, n).clip(18, 90)      # age
    X[:, 1] = rng.lognormal(9, 1.5, n)                # balance
    X[:, 2] = rng.poisson(20, n)                      # num txns
    X[:, 3] = rng.lognormal(7, 1.2, n)                # avg amount
    X[:, 4:] = rng.normal(0, 1, (n, 4))

    y = np.zeros(n, dtype=np.int64)
    order = np.arange(n); rng.shuffle(order)
    edges = set()
    idx = 0
    ring_members = []
    for _ in range(n_rings):
        size = int(rng.integers(*RING_SIZE))
        if idx + size > n: break
        ring = order[idx:idx + size]; idx += size
        y[ring] = 1
        ring_members.append(ring)
        for i in ring:
            for j in ring:
                if i < j and rng.random() < 0.6:
                    edges.add((int(i), int(j)))
        X[ring, 4] += rng.normal(0.8, 0.3, len(ring))
        X[ring, 5] += rng.normal(0.5, 0.3, len(ring))

    pool = np.where(y == 0)[0]
    target_fraud = int(fraud_rate * n)
    extra_needed = max(0, target_fraud - y.sum())
    if extra_needed > 0 and len(pool) >= extra_needed:
        extra = rng.choice(pool, size=extra_needed, replace=False)
        y[extra] = 1

    for _ in range(n * 3):
        i, j = rng.integers(0, n, 2)
        if i != j: edges.add((int(min(i, j)), int(max(i, j))))

    edges = np.array(list(edges))
    A = np.zeros((n, n), dtype=np.float32)
    A[edges[:, 0], edges[:, 1]] = 1
    A[edges[:, 1], edges[:, 0]] = 1

    bank = rng.integers(0, n_banks, n)
    X = (X - X.mean(0)) / (X.std(0) + 1e-8)
    return (X.astype(np.float32), y, A.astype(np.float32), bank,
            edges, ring_members)


# ============================================================
# MODEL
# ============================================================
class GCN(nn.Module):
    def __init__(self, in_dim, hidden, n_classes=2, p=0.3):
        super().__init__()
        self.gc1 = nn.Linear(in_dim, hidden)
        self.gc2 = nn.Linear(hidden, n_classes)
        self.p = p

    def forward(self, x, adj):
        h = F.relu(self.gc1(torch.mm(adj, x)))
        h = F.dropout(h, self.p, training=self.training)
        return self.gc2(torch.mm(adj, h))


def local_train(model, x, y, adj, epochs=LOCAL_EPOCHS, lr=LR, class_weight=None):
    model.train()
    opt = torch.optim.Adam(model.parameters(), lr=lr, weight_decay=5e-4)
    loss_fn = nn.CrossEntropyLoss(weight=class_weight)
    for _ in range(epochs):
        opt.zero_grad()
        out = model(x, adj)
        loss = loss_fn(out, y)
        loss.backward()
        opt.step()
    return model.state_dict()


def fedavg(global_state, client_states, dp=False, clip=DP_CLIP, sigma=DP_SIGMA):
    updates = []
    for cs in client_states:
        upd = {k: cs[k].float() - global_state[k].float() for k in cs}
        if dp:
            norm = torch.sqrt(sum((v ** 2).sum() for v in upd.values()))
            scale = min(1.0, clip / (norm + 1e-8))
            upd = {k: v * scale for k, v in upd.items()}
        updates.append(upd)

    new_state = {}
    K = len(updates)
    for k in global_state:
        mean = torch.stack([u[k] for u in updates]).mean(0)
        if dp:
            mean = mean + torch.randn_like(mean) * sigma * clip / K
        new_state[k] = global_state[k].float() + mean
    return new_state


def evaluate(model, x, y, adj):
    model.eval()
    with torch.no_grad():
        out = model(x, adj)
        prob = F.softmax(out, 1)[:, 1].numpy()
        pred = out.argmax(1).numpy()
    y = y.numpy()
    return {
        "acc":  float(accuracy_score(y, pred)),
        "f1":   float(f1_score(y, pred, zero_division=0)),
        "auc":  float(roc_auc_score(y, prob)) if len(np.unique(y)) > 1 else float("nan"),
        "prec": float(precision_score(y, pred, zero_division=0)),
        "rec":  float(recall_score(y, pred, zero_division=0)),
    }


# ============================================================
# BUILD CLIENTS
# ============================================================
def build_clients(X, y, A, bank, n_banks=N_BANKS):
    clients = []
    for k in range(n_banks):
        idx = np.where(bank == k)[0]
        Xk = torch.tensor(X[idx])
        yk = torch.tensor(y[idx])
        Ak = torch.tensor(normalize_adj(A[np.ix_(idx, idx)]))
        clients.append((Xk, yk, Ak, idx))
    return clients


# ============================================================
# TRAINING LOOPS (generators so Streamlit can stream results)
# ============================================================
def train_local_only(clients, class_weight, epochs=20):
    results = []
    for k, (Xk, yk, Ak, _) in enumerate(clients):
        m = GCN(FEAT_DIM, HIDDEN)
        local_train(m, Xk, yk, Ak, epochs=epochs, class_weight=class_weight)
        results.append(evaluate(m, Xk, yk, Ak))
    return results


def train_centralized(X, y, A, class_weight, epochs=20):
    m = GCN(FEAT_DIM, HIDDEN)
    Xall = torch.tensor(X); yall = torch.tensor(y)
    Aall = torch.tensor(normalize_adj(A))
    local_train(m, Xall, yall, Aall, epochs=epochs, class_weight=class_weight)
    return evaluate(m, Xall, yall, Aall), m


def train_federated(clients, X, y, A, class_weight, rounds=20,
                    dp=False, progress_cb=None):
    """Generator-free: calls progress_cb(round, metrics) each round."""
    gm = GCN(FEAT_DIM, HIDDEN)
    gs = gm.state_dict()
    Xall = torch.tensor(X); yall = torch.tensor(y)
    Aall = torch.tensor(normalize_adj(A))
    history = []
    for rnd in range(1, rounds + 1):
        cs = []
        for Xk, yk, Ak, _ in clients:
            lm = GCN(FEAT_DIM, HIDDEN)
            lm.load_state_dict(gs)
            cs.append(local_train(lm, Xk, yk, Ak, class_weight=class_weight))
        gs = fedavg(gs, cs, dp=dp)
        gm.load_state_dict(gs)
        r = evaluate(gm, Xall, yall, Aall)
        history.append({"round": rnd, **r})
        if progress_cb:
            progress_cb(rnd, r)
    return gm, history