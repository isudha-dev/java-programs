package javas.Concurrency.AdderSubtracterMutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javas.Concurrency.AdderSubtracterMutex.Adder;
import javas.Concurrency.AdderSubtracterMutex.Subtracter;
import javas.Concurrency.AdderSubtracterMutex.Value;

public class Main {

    public static void main(String[] args) throws Exception {
        Value v = new Value();
        Lock lock = new ReentrantLock();

        Adder adder = new Adder(v, lock);
        Subtracter subtracter = new Subtracter(v, lock);

        ExecutorService es = Executors.newCachedThreadPool();
        Future<Void> adderFuture = es.submit(adder);
        Future<Void> subtracterFuture = es.submit(subtracter);

        adderFuture.get();
        subtracterFuture.get();

        System.out.println(v.value);
        es.shutdown();
    }
}
