import java.util.*;

public class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int i, String n, double m) {
        id = i;
        name = n;
        marks = m;
    }

    public String toString() {
        return ("id=" + id + ", Name=" + name + ", Marks=" + marks);
    }
}

class collobj {
    public static void main(String args[]) {

        List<Student> al1 = new ArrayList<Student>();

        Student s1 = new Student(1, "Raju1", 98.9);
        Student s2 = new Student(2, "Raju2", 55.3);
        Student s3 = new Student(3, "Raju3", 79.3);
        Student s4 = new Student(4, "Raju4", 95.8);

        al1.add(s1);
        al1.add(s2);
        al1.add(s3);
        al1.add(s4);

        System.out.println("---By using for loop---");

        for(Student s : al1) {
            System.out.println(s);
        }
    }
}