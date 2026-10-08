//linear execution of thread
/*class mythread {
   public void run()
   {
    try{
        for(int i=1;i<=10;i++)
        {
            Thread.sleep(800);
            System.out.println(i);

        }
    }
    catch(Exception e)
{
    System.out.println(e);

}}
public static void main(String[] args) {
    mythread t1= new mythread();
    t1.run();
    mythread t2 = new mythread();
    t2.run();

}
   }


// 1)By Extending Thread class
/* class mythread extends Thread {
   public void run()
   {
    try{
        for(int i=1;i<=10;i++)
        {
            Thread.sleep(800);
            System.out.println(i);

        }
    }
    catch(Exception e)
{
    System.out.println(e);

}}
public static void main(String[] args) {
    mythread t1= new mythread();
    t1.start();
    mythread t2 = new mythread();
    t2.start();

}
   } 

   //2) by implementing runnable interface
class mythread implements Runnable {
   public void run()
   {
    try{
        for(int i=1;i<=10;i++)
        {
            Thread.sleep(800);
            System.out.println(i);

        }
    }
    catch(Exception e)
{
    System.out.println(e);

}}
public static void main(String[] args) {
    mythread m1= new mythread();
    Thread t1=new Thread(m1);
    t1.start();
    mythread m2 = new mythread();
    Thread t2=new Thread(m2);
    t2.start();

}
   } 

// Two diff taska with two threads. (RANDOM)
class Increment extends Thread {

    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.println("Increment: " + i);
        }
    }
}

class Decrement extends Thread {

    public void run() {
        for(int j = 10; j >= 1; j--) {
            System.out.println("Decrement: " + j);
        }
    }
}

public class mythread {

    public static void main(String[] args) {

        Increment t1 = new Increment();
        Decrement t2 = new Decrement();

        t1.start();
        t2.start();
    }
} 

// NOT RANDOM(using join)
class IncrementThread extends Thread {

    public void run() {
        System.out.println("id is" + Thread.currentThread().getPriority());
        for(int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}

class DecrementThread extends Thread {

    public void run() {
        for(int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }
}

public class mythread {

    public static void main(String[] args) {

        IncrementThread t1 = new IncrementThread();
        DecrementThread t2 = new DecrementThread();

        try {
            t1.start();
            t1.join();   // wait for t1 to finish

            t2.start();
            t2.join();   // optional
        }
        catch(Exception e) {
            System.out.println(e);
        }


    {
     priority t1 = new priority();

        t1.start();
    } 

        // get the id, state,priority, name of one thread
        class priority extends Thread {

    public void run() {

        System.out.println("Priority = " +
                Thread.currentThread().getPriority());

        System.out.println("Name = " +
                Thread.currentThread().getName());

        System.out.println("State = " +
                Thread.currentThread().getState());

        System.out.println("Thread ends.");
    }

    public static void main(String args[]) {

        priority t1 = new priority();

        t1.start();
    }
} 


 // set the id, state,priority, name of one thread
      class priority extends Thread {

    public void run() {

        System.out.println("Name = " + getName());
        System.out.println("Priority = " + getPriority());
    }

    public static void main(String args[]) {

        priority t1 = new priority();

        t1.setName("MyThread");
        t1.setPriority(8);

        t1.start();
    }
} */

//max, min, norm priorities
