package graph;

public class NumberOfIslands {

    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int count = 0;
        boolean[][] visitedArr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && !visitedArr[i][j]) {
                    DFSTravel(i, j, visitedArr, A);
                    count++;
                }
            }
        }

        return count;
    }

    public void DFSTravel(int i, int j, boolean[][] visitedArr, int[][] A) {
        visitedArr[i][j] = true;

        int[] row = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] col = { 0, 1, 1, 1, 0, -1, -1, -1 };

        for (int k = 0; k < 8; k++) {
            int rN = i + row[k];
            int cN = j + col[k];
            if (rN >= 0 && rN < A.length && cN >= 0 && cN < A[0].length && A[rN][cN] == 1 && !visitedArr[rN][cN]) {
                DFSTravel(rN, cN, visitedArr, A);
            }
        }
    }

}
