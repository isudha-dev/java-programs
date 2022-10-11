package heaps;

import java.util.PriorityQueue;

public class MaxArrSumAftrBNegations {

    public static void main(String[] args) {
        MaxArrSumAftrBNegations neg = new MaxArrSumAftrBNegations();
        neg.solve(new int[] { 24, -68, -29, -9, 84 }, 4);
    }

    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : A) {
            pq.add(i);
        }

        while (B > 0) {
            int top = pq.peek();
            pq.poll();
            pq.add(-1 * top);
            B--;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }

}
