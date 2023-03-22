package dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {

    public static void main(String[] args) {
        DistanceOfNearestCell dnc = new DistanceOfNearestCell();
        dnc.solve(new int[][] { { 1, 1, 0, 1, 1, 0 }, { 1, 1, 1, 0, 0, 0 } });
    }

    public int[][] solve(int[][] A) {
        // currDist = Min(currDist, parDist+1)

        boolean[][] visitedArr = new boolean[A.length][A[0].length];
        int[][] ansArr = new int[A.length][A[0].length];

        for (int[] arr : ansArr)
            Arrays.fill(arr, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visitedArr[i][j] = true;
                    ansArr[i][j] = 0;
                }
            }
        }

        int[] rows = { 0, 0, 1, -1 };
        int[] cols = { 1, -1, 0, 0 };

        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int i = 0; i < rows.length; i++) {
                int rN = p.r + rows[i];
                int cN = p.c + cols[i];
                if (rN >= 0 && rN < A.length && cN >= 0 && cN < A[0].length && !visitedArr[rN][cN]) {
                    q.add(new Pair(rN, cN));
                    visitedArr[rN][cN] = true;
                    ansArr[rN][cN] = Math.min(ansArr[rN][cN], ansArr[p.r][p.c] + 1);
                }
            }
        }

        return ansArr;
    }

    class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
