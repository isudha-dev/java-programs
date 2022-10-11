package heaps;

import java.util.PriorityQueue;

public class KPlacesApart {

    public static void main(String[] args) {
        KPlacesApart kp = new KPlacesApart();
        kp.solve(new int[] { 25, 16, 11, 31, 28, 20, 3, 8 }, 6);
    }

    public int[] solve(int[] A, int B) {

        if (B == 0)
            return A;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= B; i++) {
            pq.add(A[i]);
        }

        int[] ans = new int[A.length];
        int idx = 0;
        for (int i = B + 1; i < A.length; i++) {
            ans[idx] = pq.poll();
            pq.add(A[i]);
            idx++;
        }

        while (!pq.isEmpty()) {
            ans[idx] = pq.poll();
            idx++;
        }

        return ans;
    }

}
