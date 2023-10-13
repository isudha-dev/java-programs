package javas.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    List<Integer> listToSort;
    ExecutorService es;

    public Sorter(List<Integer> listToSort, ExecutorService es){
        this.listToSort = listToSort;
        this.es = es;
    }
    @Override
    public List<Integer> call() throws Exception {
        if(listToSort.size() <= 1){
            return listToSort;
        }

        // divide in 2 threads
        int size = listToSort.size();
        int mid = size/2;
        List<Integer> leftListToSort = new ArrayList<>();
        List<Integer> rightListToSort = new ArrayList<>();

        for(int i = 0; i<mid; i++){
            leftListToSort.add(listToSort.get(i));
        }

        for(int i = mid; i<size; i++){
            rightListToSort.add(listToSort.get(i));
        }

        Sorter leftListSortingTask = new Sorter(leftListToSort, es);
        Sorter rightListSortingTask = new Sorter(rightListToSort, es);

        Future<List<Integer>> sortedLeftListFuture = es.submit(leftListSortingTask);
        Future<List<Integer>> sortedRightListFuture = es.submit(rightListSortingTask);

        List<Integer> sortedLeftList = sortedLeftListFuture.get(); // blocking call until you get the list abck
        List<Integer> sortedRightList = sortedRightListFuture.get();

        // merge
        int p1 = 0;
        int p2 = 0;

        List<Integer> sortedList = new ArrayList<>();
        while (p1<sortedLeftList.size() && p2<sortedRightList.size()){
            if(sortedLeftList.get(p1) < sortedRightList.get(p2)){
                sortedList.add(sortedLeftList.get(p1));
                p1++;
            } else {
                sortedList.add(sortedRightList.get(p2));
                p2++;
            }
        }

        while(p1<sortedLeftList.size()){
            sortedList.add(sortedLeftList.get(p1));
            p1++;
        }

        while(p2<sortedRightList.size()){
            sortedList.add(sortedRightList.get(p2));
            p2++;
        }

        return sortedList;
    }
}
