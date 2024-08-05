package javas.Concurrency;

public class HelloWorldMain {

    public static void main(String[] args) {
        System.out.println(1 + " " + Thread.currentThread().getName());
        System.out.println(2 + " " + Thread.currentThread().getName());

        HelloWorldPrinter p = new HelloWorldPrinter();
        Thread t1 = new Thread(p);
        t1.start();
        // t1.run(); runs in same thread as main

        System.out.println(3 + " " + Thread.currentThread().getName());
        System.out.println(4 + " " + Thread.currentThread().getName());
    }

}
