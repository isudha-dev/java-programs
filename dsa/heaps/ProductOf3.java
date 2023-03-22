package dsa.heaps;

import java.util.PriorityQueue;

public class ProductOf3 {

    public static void main(String[] args) {
        ProductOf3 p = new ProductOf3();
        p.solve(new int[] { 11, 5, 6, 2, 8, 10 });
    }

    public int[] solve(int[] A) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[A.length];
        int idx = 0;
        int prod = 1;
        for (int i = 0; i < 3; i++) {
            pq.add(A[i]);
            prod *= A[i];
            if (i < 2)
                ans[idx] = -1;
            else
                ans[idx] = prod;
            idx++;
        }

        for (int i = 3; i < A.length; i++) {
            int top = pq.peek();
            if (A[i] > top) {
                prod = prod / top;
                pq.poll();
                pq.add(A[i]);
                prod *= A[i];
            }
            ans[idx] = prod;
            idx++;
        }

        return ans;
    }

}
