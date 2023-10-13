package javas.Concurrency.AdderSutracterAtomic;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Subtracter implements Callable<Void> {
    Value v;

    public Subtracter(Value v){
        this.v = v;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i<=100000; i++){
            this.v.value.addAndGet(-i);
        }
        return null;
    }
}
