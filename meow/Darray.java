class Darray
{
    public static void main(String args[])
    {
        int ar[] = {10,20,30,40,50,60,60,70,80,90};

        for(int i = 0; i < 10; i++)
        {
            System.out.println(ar[i]);
        }

        for(int i : ar)
        {
            System.out.println(i);
        }
    }
}
// Print All elements.
class ArrayPrint {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
// print maximum element
class ArrayMax {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};

        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Max = " + max);
    }
}
//Ascending order.
class Ascending {
    public static void main(String[] args) {
        int arr[] = {40, 10, 50, 20, 30};

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}