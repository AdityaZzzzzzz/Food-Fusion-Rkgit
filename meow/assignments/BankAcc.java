package assignments;

import java.util.Scanner;

class BankAccount
{
    String accountHolderName;
    int accountNumber;
    int balance;

    BankAccount(String name, int accNo, int bal)
    {
        accountHolderName = name;
        accountNumber = accNo;
        balance = bal;
    }

    void deposit(int amount)
    {
        balance = balance + amount;
    }

    void withdraw(int amount)
    {
        balance = balance - amount;
    }

    int getBalance()
    {
        return balance;
    }
}

public class BankAcc
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        int bal = sc.nextInt();

        BankAccount b = new BankAccount(name, accNo, bal);

        System.out.print("Enter Deposit Amount: ");
        int dep = sc.nextInt();
        b.deposit(dep);

        System.out.print("Enter Withdrawal Amount: ");
        int wd = sc.nextInt();
        b.withdraw(wd);

        System.out.println("Balance = " + b.getBalance());

        String status =
            (b.getBalance() >= 5000)
            ? "Minimum Balance Maintained"
            : "Minimum Balance not Maintained";

        System.out.println(status);
    }
}
