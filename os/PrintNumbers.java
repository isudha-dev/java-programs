import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumbers {

    public static void main(String[] args) throws InterruptedException {

        // print numbers using 3 threads
        AtomicInteger counter = new AtomicInteger(0);

        Runnable printNum = () -> {
            while (true) {
                synchronized (counter) {
                    int next = counter.incrementAndGet();
                    if (next >= 101) {
                        counter.notifyAll();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + " " + next);
                    counter.notifyAll();
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(printNum);
        Thread t2 = new Thread(printNum);
        Thread t3 = new Thread(printNum);

        t1.start();
        t2.start();
        t3.start();

    }

}
