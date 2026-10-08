public class exception {
    public static void main(String[] args) {

        int a = 100;
        int b = 0;

        System.out.println("Before Exception");

        try {
            int ar[] = new int[5];

            ar[10] = 50;   // ArrayIndexOutOfBoundsException

            int c = a / b; // ArithmeticException
            System.out.println(c);
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception");
        }

        catch (ArithmeticException e) {
            System.out.println("Cannot divide by 0");
        }

        System.out.println("After Exception");
    }
}