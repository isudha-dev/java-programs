package binaryproblems;

public class MatrixSearch {

    public static int searchMatrix(int[][] A, int B) {
        int r = 0, c = A[0].length - 1;
        while (r < A.length && c >= 0) {
            if (A[r][c] > B)
                c--;
            else if (A[r][c] < B)
                r++;
            else
                return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] A = { { 3 }, { 29 }, { 36 }, { 63 }, { 67 }, { 72 }, { 74 }, { 78 }, { 85 } };
        searchMatrix(A, 41);
    }

}
