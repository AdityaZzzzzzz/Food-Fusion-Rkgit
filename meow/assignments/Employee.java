
package assignments;
public class Employee {
  protected int id;
  protected int age;
  protected String name;
  protected boolean isPermanent;

  public static void main(String[] args) {
      Employee e=new Employee();
      e.id=7689;
      e.age=(int)35.5;
      e.name="zin";
      e.isPermanent= true ;

      System.out.println("Successfully started.");
  }
  
}
