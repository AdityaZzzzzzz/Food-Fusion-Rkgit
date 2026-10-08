import java.util.Scanner;

public class reverse {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

System.out.print(" Enter the number:");
 int x = sc.nextInt();
int sum=0;
int d;
while(x>0)
{
    d= x%10 ;
    sum= sum*10 + d;
    x= x/10;
}
System.out.println("Reverse of the number is:"+sum);
sc.close();

}

}