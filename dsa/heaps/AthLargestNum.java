package dsa.heaps;

import java.util.PriorityQueue;

public class AthLargestNum {

    public static void main(String[] args) {
        AthLargestNum al = new AthLargestNum();
        al.solve(2, new int[] { 15, 20, 99, 1 });

    }

    public int[] solve(int A, int[] B) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < A; i++) {
            pq.add(B[i]);
        }

        int[] ans = new int[B.length];
        int idx = 0;
        for (int i = 0; i < A - 1; i++) {
            ans[idx] = -1;
            idx++;
        }

        for (int i = A; i < B.length; i++) {
            ans[idx] = pq.peek();
            idx++;
            int top = pq.peek();
            if (B[i] > top) {
                pq.poll();
                pq.add(B[i]);
            }
        }

        while (idx < B.length && !pq.isEmpty()) {
            ans[idx] = pq.poll();
            idx++;
        }

        return ans;
    }

}
