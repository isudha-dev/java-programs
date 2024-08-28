package concepts.Concurrency;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/*
    Array of 50 objects
    Print 1-10 in 1 thread sequentially
    Print 11-40 in 4 thread parallel
    Print 41-50 in 1 thread sequentially
 */

public class NumberPrinter2 {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for (int i = 1; i <= 10; i++){
                System.out.println(Thread.currentThread().getName()+": "+ i);
            }
        };

        Thread t1 = new Thread(r);
        t1.start();

        Thread.sleep(5);

        AtomicInteger i = new AtomicInteger(11);
        Runnable r1 = new Runnable() {
            @Override public void run() {
                while (true){
                    synchronized (i) {
                        int next = i.getAndIncrement();
                        if (next > 40) {
                            i.notifyAll();
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + next);
                        i.notifyAll();
                        try {
                            i.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r1);
        Thread t5 = new Thread(r1);
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t2.join();
        t3.join();
        t4.join();
        t5.join();

        Runnable r2 = () -> {
            for (int j = 41; j <= 50; j++){
                System.out.println(Thread.currentThread().getName()+": "+ j);
            }
        };

        t1 = new Thread(r2);
        t1.start();
    }
}

class Number{
    ArrayList<Object> objArr;
    ArrayList<Thread> threadArr;
    Integer threadCount = 1;
    AtomicInteger i  = new AtomicInteger(1);
    Number(int count, int threadCount){
        objArr = new ArrayList<>(count);
        threadArr = new ArrayList<>(threadCount);
        this.threadCount = threadCount;

        for(int i = 0; i < count; i++ ){
            objArr.add(i+1);
        }

    }

    public void printNum(int index) {
        System.out.println(Thread.currentThread().getName()+": "+ index);
    }

    void run() throws InterruptedException {
        while(i.get() <= 10){
            printNum(i.getAndIncrement());
        }

        for(int j = 0; j < threadCount; j++){
            threadArr.add(new Thread(() ->{
                while(true){
                    synchronized (i) {
                        int next = i.get();
                        if(next > 40){
                            break;
                        }
                        printNum(i.getAndIncrement());
                    }
                }
            }));
        }

        threadArr.forEach(Thread::start);
        for (Thread t: threadArr){
            t.join();
        }

        while(i.get() <= 50){
            printNum(i.getAndIncrement());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Number number = new Number(50, 4);
        number.run();
    }

}
