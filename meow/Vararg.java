/* class Vararg
{
    public void show(int... a)
    {
        System.out.println("show method called");

        for(int x : a)
        {
            System.out.print(x + " ");
        }

        System.out.println();
    }

    public static void main(String args[])
    {
        Vararg v1 = new Vararg();

        v1.show();
        v1.show(10);
        v1.show(10,20);
        v1.show(10,20,30);
    }
} */

interface I4
{
    int show(int a, int b);
}

public class Vararg
{
    public static void main(String args[])
    {
        I1 g = (a, b) -> (a > b) ? a : b;

        System.out.println("Greatest = " + g.show(10, 20));
    }
}