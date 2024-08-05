package javas.Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger count;
    public Counter(AtomicInteger count){
        this.count = count;
    }

    public synchronized void incValue(int offset){
        int newValue = count.get() + offset;
        count.set(newValue);
    }

    public synchronized int getValue(){
        return count.get();
    }

    public synchronized void decValue(int offset){
        int newValue = count.get() - offset;
        count.set(newValue);
    }

}
