import java.util.Scanner;

class Table
{
    public static void main(String args[])
    {
        Scanner a = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int x = a.nextInt();

        for(int i = 1; i <= 10; i++)
        {
            int y = x * i;
            System.out.println(x + " * " + i + " = " + y);
        }

        a.close();
    }
}