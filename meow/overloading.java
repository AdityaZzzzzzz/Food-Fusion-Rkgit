import java.util.Scanner ;

public class overloading {
    void add(int a,int b)
    {
        System.out.println("Sum="+(a+b));

    }
       void add(int a,int b,int c)
    {
        System.out.println("Sum="+(a+b+c));

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers do u want to add (2 0r 3):");
        int Z =sc.nextInt();
        overloading ol= new overloading();
        switch(Z)
        {
        case 2 -> { 
            System.out.print("ENter first num:");
            int x=sc.nextInt();
            System.out.print("ENter second num:");
            int y=sc.nextInt();
            ol.add(x,y);
            }
        case 3 -> {
            System.out.print("ENter first num:");
                int x = sc.nextInt();
                System.out.print("ENter second num:");
                int y = sc.nextInt();
                System.out.print("ENter third num:");
                int z=sc.nextInt();
                ol.add(x,y,z);
            }

        default -> System.out.println("Invalid input. Enter either 2 or 3");

        }
        
    }
}
