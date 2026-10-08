import java.util.Scanner;

public class agevalidate {

    void validate(int age)
    {
        if(age < 18)
        {
            System.out.println("Age is not valid");
        }
        else
        {
            System.out.println("Age is valid");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        agevalidate x = new agevalidate();
        x.validate(age);
    }
}