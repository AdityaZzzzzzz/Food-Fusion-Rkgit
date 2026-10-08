package assignments;
import java.util.Scanner;

public class Calculator
{
    void add(int a, int b)
    {
        System.out.println("Sum = " + (a + b));
    }

    void add(int a, int b, int c)
    {
        System.out.println("Sum = " + (a + b + c));
    }

    void add(double a, double b)
    {
        System.out.println("Sum = " + (a + b));
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose one option:");
        System.out.println("1. Add two int numbers");
        System.out.println("2. Add three int numbers");
        System.out.println("3. Add two double numbers");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        Calculator obj = new Calculator();

        switch(choice)
        {
            case 1 ->
            {
                System.out.print("Enter first number: ");
                int x = sc.nextInt();

                System.out.print("Enter second number: ");
                int y = sc.nextInt();

                obj.add(x, y);
            }

            case 2 ->
            {
                System.out.print("Enter first number: ");
                int x = sc.nextInt();

                System.out.print("Enter second number: ");
                int y = sc.nextInt();

                System.out.print("Enter third number: ");
                int z = sc.nextInt();

                obj.add(x, y, z);
            }

            case 3 ->
            {
                System.out.print("Enter first double number: ");
                double x = sc.nextDouble();

                System.out.print("Enter second double number: ");
                double y = sc.nextDouble();

                obj.add(x, y);
            }

            default ->
            {
                System.out.println("Invalid Choice");
            }
        }

        sc.close();
    }
}