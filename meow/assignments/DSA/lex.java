package assignments.DSA;

public class lex {
    public static void main(String[] args) {
        int n = 13;
        for(int i = 1; i<=9; i++)
        {
            solve(n,i);
        
        }
    }
    private static void solve (int n , int ans){
        if ( ans>n){
            return;
        }
        System.out.println(ans);
        for( int i=0;i<=9;i++){
            solve(n,ans * 10+i);

        }
    }
}
