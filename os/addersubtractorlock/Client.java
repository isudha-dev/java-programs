package os.addersubtractorlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    // this program has race condition issue
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Count count = new Count();
        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.val);

    }

}
