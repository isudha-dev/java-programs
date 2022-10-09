package heaps;

import java.util.ArrayList;

public class ConnectingRopes {

    public static void main(String[] args) {
        ConnectingRopes cr = new ConnectingRopes();
        cr.solve(new int[] { 1, 2, 3, 4, 5 });
    }

    public int solve(int[] A) {
        for (int i : A) {
            insert(i);
        }

        int cost = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int first = extractMin();
            int second = extractMin();
            int sum = first + second;
            insert(sum);
            cost += (sum);
        }

        return cost;
    }

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
        int min = minHeap.get(0);
        minHeap.set(0, minHeap.get((n - 1)));
        minHeap.set(n - 1, min);
        minHeap.remove(n - 1);
        heapifyDown(0);

        return min;
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
                n = min;
            } else
                break;
        }
    }

}
