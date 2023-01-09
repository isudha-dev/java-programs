public class MatrixMulti {

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] B = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        int[][] res = solve(A, B);
        System.out.println(res);

    }

    static int[][] solve(int[][] A, int[][] B) {

        int[][] res = new int[A.length][B[0].length];

        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < B[0].length; c++) {
                res[r][c] = multipleRes(A, B, r, c);
            }
        }

        return res;
    }

    static int multipleRes(int[][] A, int[][] B, int r, int c) {
        int prod = 0;
        for (int i = 0; i < A[0].length; i++) {
            prod += A[r][i] * B[i][c];
        }

        return prod;
    }

}
