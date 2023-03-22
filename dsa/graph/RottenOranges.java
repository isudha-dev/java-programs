package dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        RottenOranges ro = new RottenOranges();
        ro.solve(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } });
    }

    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] timeMatrix = new int[n][m];
        for (int[] i : timeMatrix) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 2) {
                    q.add(new Pair(i, j));
                    timeMatrix[i][j] = 0;
                }
            }
        }

        int[] row = { 0, -1, 0, 1 };
        int[] col = { -1, 0, 1, 0 };

        int maxTime = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair top = q.poll();
            int val = timeMatrix[top.r][top.c];
            for (int i = 0; i < row.length; i++) {
                int rN = top.r + row[i];
                int cN = top.c + col[i];

                if (rN >= 0 && rN < n && cN >= 0 && cN < m && A[rN][cN] == 1) {
                    // if (timeMatrix[rN][cN] == Integer.MAX_VALUE || timeMatrix[rN][cN] > val + 1)
                    // {
                    A[rN][cN] = 2;
                    timeMatrix[rN][cN] = val + 1;
                    maxTime = Math.max(maxTime, timeMatrix[rN][cN]);
                    Pair newItem = new Pair(rN, cN);
                    q.add(newItem);
                    // }
                }
            }
        }

        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // if (A[i][j] == 1) {
        // max = Math.max(max, timeMatrix[i][j]);
        // }
        // }
        // }

        // if (max == Integer.MAX_VALUE)
        // return -1;
        // else
        // return max;

        for (int arr[] : A) {
            for (int num : arr) {
                if (num == 1)
                    return -1;
            }
        }
        return maxTime;

    }

    class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
