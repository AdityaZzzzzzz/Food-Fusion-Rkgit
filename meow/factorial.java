import java.util.Scanner;

class factorial
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int x = sc.nextInt();

        int a = 1;

        for(int i = 1; i <= x; i++)
        {
            a = a * i;
        }

        System.out.println("Factorial = " + a);

        sc.close();
    }
}