class A
{
    public A()
    {
        System.out.println("A constructor called");
    }
}

class B extends A
{
    {
        System.out.println("Instance initializer block");
    }

    static
    {
        System.out.println("Static initializer block");
    }

    public B()
    {
        super();
        System.out.println("B constructor called");
    }

    public static void main(String args[])
    {
        B b1 = new B();
    }
}