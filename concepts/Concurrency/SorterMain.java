package concepts.Concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SorterMain {

    public static void main(String[] args) throws Exception {
        List<Integer> listToSort = List.of(8,1,2,9,4,7,5,6,3);
        ExecutorService es = Executors.newCachedThreadPool();

        Sorter sorter = new Sorter(listToSort, es);
        List<Integer> sortedList = sorter.call();

        sortedList.stream().forEach(elem -> System.out.print(elem+" "));
        es.shutdown();
    }

}
