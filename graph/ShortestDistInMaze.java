package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistInMaze {

    public static void main(String[] args) {
        ShortestDistInMaze sdm = new ShortestDistInMaze();

        int[][] A = { { 1, 1, 0, 1 }, { 0, 0, 0, 1 }, { 1, 0, 0, 1 },
                { 0, 0, 1, 0 } };
        int[] B = { 1, 1 };
        int[] C = { 2, 1 };
        sdm.solve(A, B, C);

    }

    public int solve(int[][] A, int[] B, int[] C) {
        int[][] distance = new int[A.length][A[0].length];
        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        distance[B[0]][B[1]] = 1;

        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(B[0], B[1], 0));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int dist = p.d;
            for (int i = 0; i < rows.length; i++) {
                int rN = p.r;
                int cN = p.c;
                int count = 0;

                while (rN >= 0 && rN < A.length && cN >= 0 && cN < A[0].length && A[rN][cN] == 0) {
                    rN += rows[i];
                    cN += cols[i];
                    ++count;
                }
                rN -= rows[i];
                cN -= cols[i];
                count--;
                if ((dist + count) < distance[rN][cN]) {
                    q.add(new Pair(rN, cN, dist + count));
                    distance[rN][cN] = dist + count;
                }
            }
        }

        return distance[C[0]][C[1]] == Integer.MAX_VALUE ? -1 : distance[C[0]][C[1]];
    }

    class Pair {
        int r, c, d;

        Pair(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}