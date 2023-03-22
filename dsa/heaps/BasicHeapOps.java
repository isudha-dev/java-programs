package dsa.heaps;

import java.util.ArrayList;

public class BasicHeapOps {

    ArrayList<Integer> minHeap = new ArrayList<>();

    void insert(int x) {
        minHeap.add(x);
        int n = minHeap.size() - 1;
        heapifyUp(n);
    }

    void heapifyUp(int n) {
        while (n > 0 && minHeap.get(n) < minHeap.get((n - 1) / 2)) {
            int temp = minHeap.get(n);
            minHeap.set(n, minHeap.get((n - 1) / 2));
            minHeap.set((n - 1) / 2, temp);
            n = (n - 1) / 2;
        }
    }

    int extractMin() {
        if (minHeap.size() == 0)
            System.out.println("ERROR");
        int n = minHeap.size();
        int minm = minHeap.get(0);
        int temp = minHeap.get(0);
        minHeap.set(0, minHeap.get((n - 1)));
        minHeap.set(n - 1, temp);
        minHeap.remove(n - 1);
        heapifyDown(0);

        return minm;
    }

    void heapifyDown(int n) {
        while (n < minHeap.size()) {
            int l = 2 * n + 1, r = 2 * n + 2;
            int min = n;
            if (l < minHeap.size() && minHeap.get(l) < minHeap.get(min)) {
                min = l;
            }
            if (r < minHeap.size() && minHeap.get(r) < minHeap.get(min)) {
                min = r;
            }
            if (min != n) {
                int temp = minHeap.get(n);
                minHeap.set(n, minHeap.get(min));
                minHeap.set(min, temp);
            } else
                break;
        }
    }

}
