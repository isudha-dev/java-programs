package os.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    List<Integer> listToSort;
    ExecutorService es;

    public MergeSorter(List<Integer> listToSort, ExecutorService es) {
        this.listToSort = listToSort;
        this.es = es;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (listToSort.size() == 1) {
            System.out.println(Thread.currentThread().getName());
            return listToSort;
        }

        List<Integer> sortedList = new ArrayList<>();
        int n = listToSort.size();

        int mid = n / 2;

        List<Integer> listToSortLeft = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            listToSortLeft.add(listToSort.get(i));
        }

        List<Integer> listToSortRight = new ArrayList<>();
        for (int i = mid; i < n; i++) {
            listToSortRight.add(listToSort.get(i));
        }

        MergeSorter leftList = new MergeSorter(listToSortLeft, es);
        MergeSorter rightList = new MergeSorter(listToSortRight, es);

        Future<List<Integer>> sortedListLeftFut = es.submit(leftList);
        Future<List<Integer>> sortedListRightFut = es.submit(rightList);

        List<Integer> sortedListLeft = sortedListLeftFut.get();
        List<Integer> sortedListRight = sortedListRightFut.get();

        int l = sortedListLeft.size();
        int r = sortedListRight.size();

        int i = 0, j = 0;
        while (i < l && j < r) {
            if (sortedListLeft.get(i) <= sortedListRight.get(j)) {
                sortedList.add(sortedListLeft.get(i));
                i++;
            } else {
                sortedList.add(sortedListRight.get(j));
                j++;
            }
        }

        while (i < l) {
            sortedList.add(sortedListLeft.get(i));
            i++;
        }

        while (j < r) {
            sortedList.add(sortedListRight.get(j));
            j++;
        }

        return sortedList;
    }

}
