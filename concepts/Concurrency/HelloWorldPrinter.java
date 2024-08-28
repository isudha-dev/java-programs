package concepts.Concurrency;

public class HelloWorldPrinter implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello world 1 " + Thread.currentThread().getName());
        System.out.println("Hello world 2 " + Thread.currentThread().getName());
    }

}
