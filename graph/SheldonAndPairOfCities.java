package graph;

import java.util.Arrays;

public class SheldonAndPairOfCities {
    public static void main(String[] args) {
        SheldonAndPairOfCities sp = new SheldonAndPairOfCities();
        int[] D = { 11, 2, 2, 6, 2, 8, 9, 3, 14, 15, 4, 14, 8, 7, 8, 6, 2, 12 };
        int[] E = { 2, 1, 1, 2, 1, 1, 7, 3, 2, 13, 2, 1, 6, 1, 7, 1, 2, 10 };
        int[] F = { 8337, 6651, 29, 7765, 3428, 5213, 6431, 2864, 3137, 4024, 8169, 5013, 7375, 3786, 4326, 6415, 8982,
                6864 };
        int[] G = { 6, 2, 1, 15, 12, 2, 14, 10, 13, 15, 15, 4, 8, 7, 9, 4, 15, 13, 12, 5, 2, 10, 1, 11, 14, 7, 3, 13,
                12 };
        int[] H = { 5, 2, 15, 13, 6, 2, 8, 6, 3, 13, 15, 3, 1, 1, 4, 4, 5, 8, 1, 3, 1, 10, 15, 9, 2, 1, 1, 10, 2 };
        sp.solve(15, 18, 29, D, E, F, G, H);

    }

    public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {

        int[][] mat = new int[A + 1][A + 1];

        for (int[] row : mat) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // diagonal = 0
        for (int i = 0; i < A + 1; i++) {
            for (int j = 0; j < A + 1; j++) {
                if (i == j) {
                    mat[i][j] = 0;
                }
            }
        }

        // filling distance values
        for (int i = 0; i < B; i++) {
            if (mat[D[i]][E[i]] > F[i])
                mat[D[i]][E[i]] = F[i];
            if (mat[E[i]][D[i]] > F[i])
                mat[E[i]][D[i]] = F[i];
        }
        for (int i = 0; i < A + 1; i++) {
            for (int j = 0; j < A + 1; j++) {
                if (mat[i][j] == Integer.MAX_VALUE)
                    mat[i][j] = -1;
            }
        }

        // using floyd
        int[][] ans = floydWatshallAlgo(mat);

        int[] res = new int[G.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans[G[i]][H[i]];
        }

        return res;
    }

    public int[][] floydWatshallAlgo(int[][] A) {
        int r = A.length, c = A[0].length;
        // copy the initial state
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (A[i][j] == -1) {
                    ans[i][j] = (int) (1e9);
                } else if (i == j) {
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = A[i][j];
                }
            }
        }
        for (int k = 0; k < r; k++) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i == j) {
                        continue;
                    } else {
                        ans[i][j] = Math.min(ans[i][j], ans[i][k] + ans[k][j]);
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (ans[i][j] == (int) (1e9)) {
                    ans[i][j] = -1;
                }
            }
        }
        return ans;
    }

}
