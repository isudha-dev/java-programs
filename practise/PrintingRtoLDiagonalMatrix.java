package practise;

public class PrintingRtoLDiagonalMatrix {

    public void printRtoLDiag(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // starting at row 0
        for (int i = 0; i < m; i++) {
            int r = 0, c = i;
            while (r < n && c >= 0)
                System.out.println(mat[r][c]);
        }

        // starting at last col
        for (int i = 1; i < n; i++) {
            int r = i, c = m - 1;
            while (r < n && c >= 0)
                System.out.println(mat[r][c]);
        }

    }

}
