package concepts.Concurrency.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    Store store;
    Semaphore prudcerSemaphore;
    Semaphore consumerSemaphore;

    public Producer(Store store, Semaphore prudcerSemaphore, Semaphore consumerSemaphore){
        this.store = store;
        this.prudcerSemaphore = prudcerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override public void run() {
        while (true){
            try {
                prudcerSemaphore.acquire();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.addItem(new Object());
            consumerSemaphore.release();
        }
    }
}
