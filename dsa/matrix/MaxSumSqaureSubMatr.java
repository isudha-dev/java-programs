package dsa.matrix;

public class MaxSumSqaureSubMatr {

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(solve(A, 2));
    }

    static int solve(int[][] A, int B) {

        int[][] preA = new int[A.length][A[0].length];
        preA[0][0] = A[0][0];
        // calculating 0th row prefix sum dsa.matrix
        for (int i = 1; i < A[0].length; i++) {
            preA[0][i] = (preA[0][i - 1] + A[0][i]);
        }
        // calculating 0th col prefix sum dsa.matrix
        for (int i = 1; i < A.length; i++) {
            preA[i][0] = (preA[i - 1][0] + A[i][0]);
        }
        // calculating remaining prefix sum dsa.matrix
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {
                preA[i][j] = (preA[i - 1][j] + preA[i][j - 1] - preA[i - 1][j - 1] + A[i][j]);
            }
        }

        int ans = Integer.MIN_VALUE;
        int N = A.length;
        for (int r1 = 0; r1 <= N - B; r1++) {
            for (int c1 = 0; c1 <= N - B; c1++) {
                int r2 = r1 + B - 1;
                int c2 = c1 + B - 1;
                int sum = 0;
                if (r1 == 0 && c1 == 0) {
                    sum = preA[r2][c2];
                } else if (r1 == 0) {
                    sum = (preA[r2][c2] - preA[r2][c1 - 1]);
                } else if (c1 == 0) {
                    sum = (preA[r2][c2] - preA[r1 - 1][c2]);
                } else {
                    sum = (preA[r2][c2] - preA[r2][c1 - 1] - preA[r1 - 1][c2]
                            + preA[r1 - 1][c1 - 1]);
                }
                ans = Math.max(ans, sum);

            }

        }

        return ans;
    }

}
