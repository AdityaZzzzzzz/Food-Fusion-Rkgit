package assignments;
import java.util.Scanner;

public class Gradecalculation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Marks of the Following Subjects: \n Enter Physics marks: ");
        int physics = sc.nextInt();

        System.out.print("Enter Chem marks: ");
        int chemistry = sc.nextInt();

        System.out.print("Enter Bio marks: ");
        int biology = sc.nextInt();

        System.out.print("Enter English marks: ");
        int english = sc.nextInt();

        System.out.print("Enter Java marks: ");
        int java = sc.nextInt();

        int total = physics + chemistry + biology + english + java;
        double average = total / 5.0;

        System.out.println("Total Marks = " + total);
        System.out.println("Average = " + average);

        if(average > 90)
            System.out.println("Grade = Ex");
        else if(average > 80)
            System.out.println("Grade = A");
        else if(average > 60)
            System.out.println("Grade = B");
        else if(average >= 40)
            System.out.println("Grade = C");
        else
            System.out.println("Grade = F");
    }
}