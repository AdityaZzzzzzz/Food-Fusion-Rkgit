import java.util.Scanner;
import java.lang.Math.sqrt;
//the great ariba wrote this code while teaching a peasant.
public class primee 
{
    public static void main(String args[])
    {

    Scanner sc=new Scanner(System.in);
    soln obj=new soln();
    System.out.print("enter the number:");
    int num=sc.nextInt();
    System.out.println("the number is " + obj.prime(num));
    sc.close();
    }
}
    class soln {
    String prime(int num)
    {
        if (num<=1)
        {
            return ("not prime");
        }
       int count=0;
       for (int i=1;i<=num;i++)
       {
        if (num%i==0){
            count++;
       }
       }
       if (count==2)
       {
        return("prime");
       }

       else{
        return("not prime");
       }  
    }
    }

