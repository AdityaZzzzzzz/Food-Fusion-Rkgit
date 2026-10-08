class Student {
int id;
String name;
float marks;

public void init(int i,String n, float m)
{
id=i;
name=n;
marks=m;

}
 public void display()
 {
System.out.println("id="+id+",Name:"+name+"Marks:"+marks);
 }   
}
class Sec
{
    public static void main(String[] args) {
        Student s1=new Student();
        s1.init(1,"Abhi",69);
        s1.display();
    }
}