package javas.Concurrency.AdderSubtracterSync;

import java.util.concurrent.Callable;

public class Subtracter implements Callable<Void> {
    Value v;

    public Subtracter(Value v){
        this.v = v;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i<=10000; i++){
            synchronized (v) {
                this.v.value -= i;
            }
        }
        return null;
    }
}
