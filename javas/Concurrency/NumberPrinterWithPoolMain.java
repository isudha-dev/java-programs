package javas.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberPrinterWithPoolMain {

    // print number 1 to 100 from 10 different threads

    public static void main(String[] args) {
//        ExecutorService es = Executors.newFixedThreadPool(10);
        ExecutorService es = Executors.newCachedThreadPool();

        for(int i = 1; i <= 100; i++){
            NumberPrinter np = new NumberPrinter(i);
            es.execute(np);
        }
    }

}
