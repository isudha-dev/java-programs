public class Array2DRotationTransposeSq {

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // array before
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int r = 0; r < A.length; r++) { // 0 - 4
            int c = r;
            while (c >= r && c < A.length) {
                int temp = A[r][c];
                A[r][c] = A[c][r];
                A[c][r] = temp;
                c++;
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
