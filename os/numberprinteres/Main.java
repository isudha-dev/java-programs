package os.numberprinteres;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting to print number in thread " + Thread.currentThread().getName());
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 100; i++) {
            es.execute(new NumberPrinter(i));
        }

        es.shutdown();
        try {
            es.awaitTermination(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}