package javas.Concurrency.AdderSubtracterMutex;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import javas.Concurrency.AdderSubtracterMutex.Value;

public class Adder implements Callable<Void> {
    Value v;
    Lock lock;

    public Adder(Value v, Lock lock){
        this.v = v;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i<=10000; i++){
            lock.lock();
            this.v.value += i;
            lock.unlock();
        }
        return null;
    }
}
