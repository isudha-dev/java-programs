package javas.Concurrency.AdderSubtracter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        Value v = new Value();
        Adder adder = new Adder(v);
        Subtracter subtracter = new Subtracter(v);

        ExecutorService es = Executors.newCachedThreadPool();
        Future<Void> adderFuture = es.submit(adder);
        Future<Void> subtracterFuture = es.submit(subtracter);

        adderFuture.get();
        subtracterFuture.get();

        System.out.println(v.value);
        es.shutdown();
    }
}
