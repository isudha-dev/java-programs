package concepts.Concurrency.AdderSubtracterMutex;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import concepts.Concurrency.AdderSubtracterMutex.Value;

public class Subtracter implements Callable<Void> {
    Value v;
    Lock lock;

    public Subtracter(Value v, Lock lock){
        this.v = v;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i<=10000; i++){
            lock.lock();
            this.v.value -= i;
            lock.unlock();
        }
        return null;
    }
}
