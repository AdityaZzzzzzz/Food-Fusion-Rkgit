import java.util.*;

public class collection {

    public static void main(String[] args) {

        ArrayList<String> al1 = new ArrayList<String>();

        al1.add("raju");
        al1.add("raju");
        al1.add("raju");
        al1.add("eeba");
        al1.add("raju");
        al1.add("raju");

        System.out.println("Using for-each loop");

        for (String str : al1) {
            System.out.println(str);
        }

        System.out.println("Using Iterator");

        Iterator<String> itr = al1.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}