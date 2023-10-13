package javas.Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterMain {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(10);
        Counter counter = new Counter(count);

        counter.incValue(10);
        System.out.println(counter.getValue());

        counter.decValue(10);
        System.out.println(counter.getValue());
    }

}
