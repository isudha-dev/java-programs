package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {
    public static void main(String[] args) {
        ValidPath vp = new ValidPath();
        vp.solve(2, 3, 1, 1, new int[] { 2 }, new int[] { 3 });
        // vp.solve(4, 4, 3, 1, new int[] { 1, 0, 3 }, new int[] { 3, 2, 1 });
        // vp.solve(61, 91, 6, 2, new int[] { 53, 42, 27, 34, 58, 29 }, new int[] { 16,
        // 54, 33, 40, 30, 23 });
    }

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {

        for (int i = 0; i < C; i++) {
            if (E[i] == A && F[i] == B)
                return "NO";
        }

        int[][] matx = new int[B + 1][A + 1];
        for (int[] m : matx) {
            Arrays.fill(m, 1);
        }

        // rows - Y, cols - X
        for (int k = 0; k < C; k++) {
            for (int i = 0; i <= B; i++) {
                for (int j = 0; j <= A; j++) {
                    int exp1 = (E[k] - j) * (E[k] - j);
                    int exp2 = (F[k] - i) * (F[k] - i);
                    int exp = (exp1 + exp2);
                    if (exp <= (D * D) && matx[i][j] == 1) {
                        matx[i][j] = 0;
                    }
                }
            }
        }

        // printing steps
        // for (int i = B; i >= 0; i--) {
        // for (int j = 0; j <= A; j++) {
        // System.out.print(matx[i][j] + " ");
        // }
        // System.out.println();
        // }

        if (matx[0][0] == 0)
            return "NO";

        int rows[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int cols[] = { 1, 1, 0, -1, -1, -1, 0, 1 };

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        matx[0][0] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int i = 0; i < rows.length; i++) {
                int rN = p.y + rows[i];
                int cN = p.x + cols[i];
                if (rN >= 0 && rN <= B && cN >= 0 && cN <= A && matx[rN][cN] == 1) {
                    matx[rN][cN] = 0;
                    if (rN == B && cN == A) {
                        // printing steps
                        // for (int m = B; m >= 0; m--) {
                        // for (int n = 0; n <= A; n++) {
                        // System.out.print(matx[m][n] + " ");
                        // }
                        // System.out.println();
                        // }
                        return "YES";
                    }
                    q.add(new Pair(rN, cN));
                }
            }
        }

        // printing steps
        // for (int m = B; m >= 0; m--) {
        // for (int n = 0; n <= A; n++) {
        // System.out.print(matx[m][n] + " ");
        // }
        // System.out.println();
        // }
        return "NO";
    }

    class Pair {
        int y, x;

        Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

}
