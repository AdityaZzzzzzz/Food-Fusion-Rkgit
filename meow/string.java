//Total no of characters without using length.
/*import java.util.Scanner;
public class string {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter String:");

        String s = sc.nextLine();

        int count = 0;

        for(char ch : s.toCharArray()) {
            count++;
        }

        System.out.println("Characters = " + count);
        sc.close();
        }
}*/
// using length now:
public class string {
    public static void main(String[] args) {

        String str = "kuchisabishi";

        int count = str.length();

        System.out.println("Characters = " + count);
    }
}