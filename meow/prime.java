import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the Number:");
        int a= sc.nextInt();
        int p=0;
        for (int i =1; i <= a; i++) {
            if (a%i==0)
                p++;       
        }
        if(p==2)
            System.out.println("Prime number");
        else 
            System.out.println("Not a Prime Number");
        sc.close();

    }

    
}
