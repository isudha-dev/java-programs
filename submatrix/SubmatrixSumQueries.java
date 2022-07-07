package submatrix;

// https://www.scaler.com/academy/mentee-dashboard/class/29823/assignment/problems/4088?navref=cl_tt_nv
// Sum may be large, so return the answer mod 109 + 7.
public class SubmatrixSumQueries {

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        solve(A, new int[] { 1, 2 }, new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 3 });
    }

    static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

        int mod = 1000000007;
        long[][] preA = new long[A.length][A[0].length];
        preA[0][0] = A[0][0];
        // calculating 0th row prefix sum matrix
        for (int i = 1; i < A[0].length; i++) {
            preA[0][i] = (preA[0][i - 1] % mod + A[0][i] % mod) % mod;
        }
        // calculating 0th col prefix sum matrix
        for (int i = 1; i < A.length; i++) {
            preA[i][0] = (preA[i - 1][0] % mod + A[i][0] % mod) % mod;
        }
        // calculating remaining prefix sum matrix
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {
                preA[i][j] = (preA[i - 1][j] % mod + preA[i][j - 1] % mod - preA[i - 1][j - 1] % mod + A[i][j] % mod)
                        % mod;
            }
        }
        int ans[] = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int r1 = B[i] - 1;
            int c1 = C[i] - 1;
            int r2 = D[i] - 1;
            int c2 = E[i] - 1;
            long sum = 0;
            if (r1 == 0 && c1 == 0) {
                sum = preA[r2][c2] % mod;
            } else if (r1 == 0) {
                sum = (preA[r2][c2] % mod - preA[r2][c1 - 1] % mod) % mod;
            } else if (c1 == 0) {
                sum = (preA[r2][c2] % mod - preA[r1 - 1][c2] % mod) % mod;
            } else {
                sum = (preA[r2][c2] % mod - preA[r2][c1 - 1] % mod - preA[r1 - 1][c2] % mod
                        + preA[r1 - 1][c1 - 1] % mod) % mod;
            }
            sum = (sum + mod) % mod;
            ans[i] = (int) sum;
        }
        return ans;

    }
}
