package dsa.arrayrotation;

public class Array2DRotation270 {

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

        // array before
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int[][] B = new int[A[0].length][A.length];

        // row col change - transpose
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                B[c][r] = A[r][c];
            }

        }

        // reversing
        int nB = B.length;
        for (int c = 0; c < B[0].length; c++) {
            int r = 0;
            while (r < B.length / 2) {
                int temp = B[r][c];
                B[r][c] = B[nB - 1 - r][c];
                B[nB - 1 - r][c] = temp;
                r++;
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
