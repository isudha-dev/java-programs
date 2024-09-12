package concepts.Concurrency.ProducerConsumerSemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Store {
    private int maxSize;
    ConcurrentLinkedQueue<Object> items;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ConcurrentLinkedQueue<>();
    }

    public void addItem(Object o){
        items.add(o);
        System.out.println("Item produced: "+ items.size());
    }

    public void removeItem(){
        items.remove();
        System.out.println("Item consumed: "+ items.size());
    }
}
