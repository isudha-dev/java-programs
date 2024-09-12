package concepts.Concurrency.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    Store store;
    Semaphore prudcerSemaphore;
    Semaphore consumerSemaphore;

    public Consumer(Store store, Semaphore prudcerSemaphore, Semaphore consumerSemaphore){
        this.store = store;
        this.prudcerSemaphore = prudcerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override public void run() {
        while (true){
            try {
                consumerSemaphore.acquire();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.removeItem();
            prudcerSemaphore.release();
        }
    }
}
