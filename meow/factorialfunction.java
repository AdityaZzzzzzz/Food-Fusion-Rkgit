import java.util.Scanner;

public class factorialfunction
{
    static int fact(int x)
    {
        int y = 1;

        for(int i = 1; i <= x; i++)
        {
            y = y * i;
        }

        return y;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int a = sc.nextInt();

        System.out.println("Factorial of number is: " + fact(a));

        sc.close();
    }
}