public class MaxAreaOfIsland {

    public static void main(String[] args) {

        int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

        // printGrid(grid);
        // System.out.println();
        System.out.println(maxAreaOfIsland(grid));
    }

    static int maxAreaOfIsland(int[][] grid) {
        int gridLength = grid.length;
        int gridWidth = grid[0].length;
        int ans = 0;
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (grid[i][j] != 0) {
                    ans = Math.max(ans, countNeighbourIsland(i, j, grid, 1));
                    // printGrid(grid);
                    // System.out.println();
                }
            }
        }

        return ans;
    }

    static int countNeighbourIsland(int l, int r, int[][] grid, int count) {
        if (l < 0 || r < 0 || l >= grid.length || r >= grid[0].length) {
            return 0;
        }

        if (grid[l][r] == 0) {
            return 0;
        }
        grid[l][r] = 0;

        int leftCount = countNeighbourIsland(l, r - 1, grid, count); // left
        int topCount = countNeighbourIsland(l - 1, r, grid, count); // top
        int rightCount = countNeighbourIsland(l, r + 1, grid, count); // right
        int bottomCount = countNeighbourIsland(l + 1, r, grid, count); // bottom

        count += (leftCount + topCount + rightCount + bottomCount);
        grid[l][r] = 0;

        return count;

    }

    static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}
