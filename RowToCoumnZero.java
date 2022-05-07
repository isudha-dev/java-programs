import java.util.ArrayList;

public class RowToCoumnZero {
    public static void main(String[] args) {

        int[][] A = { { 1, 2, 3, 4 }, { 5, 6, 7, 0 }, { 9, 2, 0, 4 } };
        int[][] B = solve(A);
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] solve(int[][] A) {

        ArrayList<Integer> idx = new ArrayList<>();

        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if (A[r][c] == 0) {
                    idx.add(r);
                    idx.add(c);
                }

            }
        }

        for (int i = 0; i < idx.size(); i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < A[0].length; j++) {
                    A[idx.get(i)][j] = 0;
                }
            } else {
                for (int j = 0; j < A.length; j++) {
                    A[j][idx.get(i)] = 0;
                }
            }

        }

        return A;
    }

}
