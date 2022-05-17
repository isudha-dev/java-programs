package array_rotation;

public class Array2DRotationTranspose {

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

        for (int r = 0; r < A[0].length; r++) { // 0 - 4
            for (int c = 0; c < A.length; c++) { // 0 - 3
                B[r][c] = A[c][r];
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
