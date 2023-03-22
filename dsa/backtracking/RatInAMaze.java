package dsa.backtracking;

public class RatInAMaze {

    public static void main(String[] args) {
        RatInAMaze rm = new RatInAMaze();
        int[][] A = { { 1, 0 }, { 1, 1 } };
        rm.solve(A);
    }

    public int[][] solve(int[][] A) {
        // initializing 2D arrayLsit with default value.
        // List<ArrayList<Integer>> ans = new ArrayList<>(
        // Collections.nCopies(A.size(), new ArrayList<>(Collections.nCopies(A.size(),
        // 0))));

        int[][] ans = new int[A.length][A.length];

        solveRatMaze(A, ans, 0, 0);
        return ans;
    }

    public boolean solveRatMaze(int[][] A, int[][] ans, int i, int j) {

        if (i >= A.length || j >= A.length || A[i][j] == 0) {
            return false;
        }

        if (i == A.length - 1 && j == A.length - 1) {
            ans[i][j] = 1;
            return true;
        }

        ans[i][j] = 1;
        boolean right = solveRatMaze(A, ans, i, j + 1);
        boolean down = solveRatMaze(A, ans, i + 1, j);

        if (right || down)
            return true;

        ans[i][j] = 0;
        return false;
    }

}
