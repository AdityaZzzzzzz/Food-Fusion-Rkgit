import java.util.Scanner;

class Power
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number followed by power");
        int x = sc.nextInt();
        int y = sc.nextInt();

        int z = 1;
        int i = 0;
        if (y==0)
        System.out.println("Answer:1");
        else {

        do
        {
            z = z * x;
            i++;
        }
        while(i < y);
    
        System.out.println("Answer = " + z);
    }
        sc.close();
    }
}





