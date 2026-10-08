interface I1
{
    public void show();
    public void display();
}

abstract class X implements I1
{
    @Override
    public void display()
    {
        System.out.println("Display from A class");
    }
}

class Y extends X
{
    @Override
    public void show()
    {
        System.out.println("Show in B class");
    }

    public static void main(String args[])
    {
        I1 b1 = new Y();

        b1.show();
        b1.display();
    }
}
