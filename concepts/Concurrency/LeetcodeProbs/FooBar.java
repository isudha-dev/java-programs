package javas.Concurrency.LeetcodeProbs;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;
    Semaphore f = null;
    Semaphore b = null;


    public FooBar(int n) {
        this.n = n;
        f = new Semaphore(1);
        b = new Semaphore(0);
    }

    public  void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            f.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            b.release();
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            b.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            f.release();
        }

    }
}
