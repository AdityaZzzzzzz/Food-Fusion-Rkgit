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
class C extends B
{
    public void print()
    {
        System.out.println("print no.3");
    }
}
public class multilevel
{
public static void main(String [] args)
{
C c1= new C();
c1.print();
c1.show();
c1.display();

}
}