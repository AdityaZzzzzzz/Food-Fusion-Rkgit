package assignments;
import java.util.Scanner;

public class Car {
    String make;
    String model;
    short year;
    int price;

    Car(String make, String model, short year, int price)
   {
this.make=make;
this.model=model;
this.year=year;
this.price=price;
   } 
   void display()
   {
    System.err.println("Make:"+make);
    System.out.println("Model : " + model);
    System.out.println("Year  : " + year);
    System.out.println("Price : " + price);
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.print("Enter Make: ");
        String make = sc.nextLine();

        System.out.print("Enter Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Year: ");
        short year = sc.nextShort();

        System.out.print("Enter Price: ");
        int price = sc.nextInt();

        Car c1 = new Car(make, model, year, price);

        System.out.println("Car Details:");
        c1.display();

        sc.close();
    }
}
  

