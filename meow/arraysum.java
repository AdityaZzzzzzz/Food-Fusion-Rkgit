// Print sum of all elements.
/*
class arraysum {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        System.out.println("Sum = " + sum);
    }
}
 */
// 2D sum
 /* public class arraysum
{
    public static void main(String args[])
    {
        int ar[][] = {
            {10, 20},
            {30, 40}
        };

        int sum = 0;

        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                sum = sum + ar[i][j];
            }
        }

        System.out.println("Sum = " + sum);
    }
}*/
// 3D sum
/* 
public class arraysum {

    public static void main(String args[]) {

        int ar[][] = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        int sum = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                sum = sum + ar[i][j];
            }
        }

        System.out.println("Sum = " + sum);
    }
}
    */

// Diagonal sum
/*public class DiagonalSum
{
    public static void main(String args[])
    {
        int ar[][] = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        int sum = 0;

        for(int i = 0; i < 3; i++)
        {
            sum += ar[i][i];
        }

        System.out.println("Diagonal Sum = " + sum);
    }
}*/
//Sum of two 3D matrix.
public class arraysum {

    public static void main(String args[]) {

        int ar1[][] = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        int ar2[][] = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        int ar3[][] = new int[3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                ar3[i][j] = ar1[i][j] + ar2[i][j];
            }
        }

        System.out.println("Sum Matrix:");

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(ar3[i][j] + " ");
            }
            System.out.println();
        }
    }
}