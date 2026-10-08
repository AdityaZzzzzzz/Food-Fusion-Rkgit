 class A {
public void display()
{
    System.out.println("display no.1");

} 
}
class B extends A
{
    public void show()
    {
        System.out.println("show no.2");
    }
}
class C extends A
{
    public void print()
    {
        System.out.println("print no.3");
    }
}
public class heirarchial
{
public static void main(String [] args)
{
C c1= new C();
c1.print();
c1.display();
B b1= new B();
b1.display();
b1.show();
}
}