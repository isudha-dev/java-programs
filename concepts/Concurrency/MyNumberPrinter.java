package concepts.Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

// printing number 1 to 50 using 3 different threads.
public class MyNumberPrinter {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger i = new AtomicInteger(1);
        Runnable r = () -> {
          while (true){
              synchronized (i) {
                  if(i.get() > 50){
                      i.notifyAll();
                      break;
                  }
                  System.out.println(Thread.currentThread().getName() +" : "+ i.get());
                  i.getAndIncrement();
                  i.notifyAll();
                  try {
                      i.wait();
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
              }
          }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
