package greedy;

import java.util.PriorityQueue;

public class ShipCompany {

    public static void main(String[] args) {
        ShipCompany sc = new ShipCompany();
        sc.solve(4, 3, new int[] { 2, 2, 2 });
    }

    public int[] solve(int A, int B, int[] C) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        int minCost = 0, maxCost = 0;

        for (int i = 0; i < B; i++) {
            minHeap.add(C[i]);
            maxHeap.add(C[i]);
        }

        while (A > 0) {
            // calculating min cost
            int minTop = minHeap.poll();
            minCost += minTop;
            if ((minTop - 1) != 0)
                minHeap.add(minTop - 1);

            // calculating max cost
            int maxTop = maxHeap.poll();
            maxCost += maxTop;
            if ((maxTop - 1) != 0)
                maxHeap.add(maxTop - 1);

            A--;
        }

        return new int[] { maxCost, minCost };
    }

}
