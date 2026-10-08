import java.util.Scanner;

public class transpose
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int ar[][] = new int[3][3];

        System.out.println("Enter 9 elements:");

       
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                ar[i][j] = sc.nextInt();
            }
        }

        // Transpose
        System.out.println("Transpose:");

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print(ar[j][i] + " ");
            }
            System.out.println();
        }
    }
}