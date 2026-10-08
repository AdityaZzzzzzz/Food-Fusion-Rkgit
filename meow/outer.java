/*class Outer
{
    public void display()
    {
        class Inner
        {
            public void show()
            {
                System.out.println("Show from inner class");
            }
        }

        Inner i1 = new Inner();
        i1.show();
    }

    public static void main(String args[])
    {
        Outer o1 = new Outer();
        o1.display();
    }
}*/
interface I1
{
   public void show();
}

class Annoninner
{
    public static void main(String args[])
    {
        I1 a1 = new I1()
        {
            public void show()
            {
                System.out.println("Show from anonymous inner class");
            }
        };

        a1.show();
    }
}