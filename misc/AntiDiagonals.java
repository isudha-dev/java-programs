public class AntiDiagonals {

    // https://www.scaler.com/academy/mentee-dashboard/class/25553/assignment/problems/293?navref=cl_tt_nv
    public static void main(String[] args) {

        int[][] A = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };
        int[][] ans = diagonal(A);
        for (int r = 0; r < (2 * A.length - 1); r++) {
            for (int c = 0; c < A[0].length; c++) {
                System.out.print(ans[r][c] + " ");
            }
            System.out.println();
        }

    }

    static int[][] diagonal(int[][] A) {
        int n = A.length;
        int[][] res = new int[2 * n - 1][n];

        // For each column start row is 0
        for (int col = 0; col < n; col++) {
            int startcol = col, startrow = 0;
            int resCol = 0;
            while (startcol >= 0 && startrow < n) {
                System.out.print(A[startrow][startcol] + " ");
                res[col][resCol] = A[startrow][startcol];
                startcol--;
                startrow++;
                resCol++;
            }
            System.out.println();
        }

        // For each row start column is N-1
        for (int row = 1; row < n; row++) {
            int startrow = row, startcol = n - 1;
            int resCol = 0;
            while (startrow < n && startcol >= 0) {
                System.out.print(A[startrow][startcol] + " ");
                res[row + n - 1][resCol] = A[startrow][startcol];
                startcol--;
                startrow++;
                resCol++;
            }
            System.out.println();
        }

        return res;
    }

}
