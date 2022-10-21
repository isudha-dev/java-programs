package heaps;

import java.util.PriorityQueue;

public class KthSmallestNumInSortedMatrix {

    public static void main(String[] args) {
        KthSmallestNumInSortedMatrix ksm = new KthSmallestNumInSortedMatrix();
        ksm.solve(new int[][] { { 9, 11, 15 }, { 10, 15, 17 } }, 6);
    }

    public int solve(int[][] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (B > 0) {
                    pq.add(A[i][j]);
                    B--;
                } else {
                    int top = pq.peek();
                    if (A[i][j] < top) {
                        pq.poll();
                        pq.add(A[i][j]);
                    }
                }
            }
        }

        return pq.poll();
    }

}
