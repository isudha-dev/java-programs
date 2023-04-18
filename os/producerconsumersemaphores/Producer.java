package os.producerconsumersemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    Queue<Object> store;
    int cap;
    String name;

    Semaphore ps;
    Semaphore cs;

    Producer(Queue<Object> store, int cap, String name, Semaphore ps, Semaphore cs){
        this.store = store;
        this.cap = cap;
        this.name = name;
        this.ps = ps;
        this.cs = cs;
    }

    @Override public void run() {
        while (true){

            try {
                ps.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//          synchronized (store){
//              if(store.size() < cap){
                System.out.println("Added by: "+name +" has size: "+store.size());
                store.add(new Object());
//              }
//          }
            cs.release();

        }
    }
}
