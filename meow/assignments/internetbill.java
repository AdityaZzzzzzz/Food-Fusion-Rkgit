package assignments;

import java.util.Scanner;

public class internetbill {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data consumed (GB): ");
        int gb = sc.nextInt();

        double bill;

        if(gb < 10) {
            bill = 300;
        }
        else if(gb <= 30) {
            bill = 300 + 5 * (gb - 10);
        }
        else {
            bill = 400 + 3 * (gb - 30);
        }

        System.out.println("Bill Amount = Rs." + bill);
    }
}