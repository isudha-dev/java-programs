package dsa.heaps;

import java.util.PriorityQueue;

public class BClosestPointToOrigin {

    public static void main(String[] args) {
        BClosestPointToOrigin bc = new BClosestPointToOrigin();
        bc.solve(new int[][] { { 1, 3 }, { -2, 2 } }, 1);
    }

    class Pair {
        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[][] solve(int[][] A, int B) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        for (int i = 0; i < A.length; i++) {
            int s1 = A[i][0] * A[i][0];
            int s2 = A[i][1] * A[i][1];
            pq.add(new Pair(s1 + s2, i));
        }
        while (pq.size() > B) {
            pq.poll();
        }
        int[][] res = new int[B][2];
        int k = 0;
        while (!pq.isEmpty()) {
            int idx = pq.poll().index;
            res[k][0] = A[idx][0];
            res[k][1] = A[idx][1];
            k++;
        }
        return res;
    }

}
