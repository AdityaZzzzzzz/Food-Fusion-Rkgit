import java.io.*;

public class filehandling {

    public static void main(String[] args) {

        try {

            FileOutputStream fout = new FileOutputStream("my.txt");

            String s = "Hi hello how are you memememmeme";

            byte[] data = s.getBytes();

            fout.write(data);

            fout.close();

            System.out.println("Data written successfully");

        } catch (Exception e) {

            System.out.println("Exception is: Diabolical " + e);
        }
    }
}