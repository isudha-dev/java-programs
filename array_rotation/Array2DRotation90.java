package array_rotation;

public class Array2DRotation90 {

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };

        // array before
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int[][] B = new int[A[0].length][A.length];

        // row col change
        for (int c = 0; c < A[0].length; c++) {
            for (int r = 0; r < A.length; r++) {
                B[c][r] = A[r][c];
            }
        }

        // reversing
        int n = B[0].length;
        for (int r = 0; r < B.length; r++) {
            int c = 0;
            while (c < B[0].length / 2) {
                int temp = B[r][c];
                B[r][c] = B[r][n - 1 - c];
                B[r][n - 1 - c] = temp;
                c++;
            }
        }

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }

    }

}
