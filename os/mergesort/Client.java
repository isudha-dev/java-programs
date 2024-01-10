package os.mergesort;

import os.mergesort.MergeSorter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        List<Integer> listToSort = List.of(7, 10, 5, 6, 12, 8, 5, 0, 1);
        MergeSorter ms = new MergeSorter(listToSort, es);
        Future<List<Integer>> sortedList = es.submit(ms);
        System.out.println(sortedList.get());
        es.shutdown();
    }

}
