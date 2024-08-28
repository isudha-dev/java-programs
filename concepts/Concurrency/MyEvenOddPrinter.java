package concepts.Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class MyEvenOddPrinter {
    private int max;
    private volatile boolean isOdd = false;

    public MyEvenOddPrinter(int max){
        this.max = max;
    }

    public void printEven(){
        synchronized (this){
            for (int i = 2; i <= max ; i += 2) {
                while (isOdd){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(Thread.currentThread().getName() +" : " +i);
                isOdd = true;
                notify();
            }
        }
    }

    public void printOdd() {
        synchronized (this){
            for (int i = 1; i <= max; i += 2) {
                while (!isOdd){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(Thread.currentThread().getName()+ " : " +i);
                isOdd = false;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        MyEvenOddPrinter eo = new MyEvenOddPrinter(20);
        Thread t1 = new Thread(eo::printEven, "Even Thread");
        Thread t2 = new Thread(eo::printOdd, "Odd Thread");
        t1.start();
        t2.start();
    }

}
