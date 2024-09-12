package concepts.Concurrency.AdderSutracterAtomic;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    Value v;

    public Adder(Value v){
        this.v = v;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i<=100000; i++){
            this.v.value.addAndGet(+i);
        }
        return null;
    }
}
