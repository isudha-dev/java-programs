package array_rotation;

public class Array2DRotation90InPlace {

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        // array before
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int n = A.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = A[i][j];
                A[i][j] = A[n - j - 1][i];
                A[n - 1 - j][i] = A[n - i - 1][n - j - 1];
                A[n - i - 1][n - j - 1] = A[j][n - i - 1];
                A[j][n - i - 1] = temp;
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

    }

}
