package dsa.graph;

public class NoOfEnclaves {

    public static void main(String[] args) {
//        int[][] grid = new int[][] {{0,0,1,1,0,1,0,0,1,0}, {1,1,0,1,1,0,1,1,1,0}, {1,0,1,1,1,0,0,1,1,0}, {0,1,1,0,0,0,0,1,0,1}, {0,0,0,0,0,0,1,1,1,0}, {0,1,0,1,0,1,0,1,1,1}, {1,0,1,0,1,1,0,0,0,1}, {1,1,1,1,1,1,0,0,0,0}, {1,1,1,0,0,1,0,1,0,1}, {1,1,1,0,1,1,0,1,1,0}};
//        int[][] grid = new int[][] {{0,0,0,0}, {1,0,1,0}, {0,0,1,0}, {0,0,0,0}, {0,1,0,0}, {0,1,1,0}, {0,0,0,0}};
//        int[][] grid = new int[][] {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        int[][] grid = new int[][] {{0,0,0,1,1,1,0,1,0,0},{1,1,0,0,0,1,0,1,1,1},{0,0,0,1,1,1,0,1,0,0},{0,1,1,0,0,0,1,0,1,0},{0,1,1,1,1,1,0,0,1,0},{0,0,1,0,1,1,1,1,0,1},{0,1,1,0,0,0,1,1,1,1},{0,0,1,0,0,1,0,1,0,1},{1,0,1,0,1,1,0,0,0,0},{0,0,0,0,1,1,0,0,0,1}};
        System.out.println("No of Enclaves: "+ numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visitedArr = new boolean[r][c];

        // marking all cells connected with boundary

        // 1st row
        for(int i = 0 ; i < c; i++){
            if(grid[0][i] == 1 && !visitedArr[0][i]) {
                dfsTravelAndMark(0, i, grid);
            }
        }

        // last row
        for(int i = 0 ; i < c; i++){
            if(grid[r-1][i] == 1 && !visitedArr[r-1][i]) {
                dfsTravelAndMark(r-1, i, grid);
            }
        }

        // 1st col
        for(int i = 1 ; i < r - 1; i++){
            if(grid[i][0] == 1 && !visitedArr[i][0]) {
                dfsTravelAndMark(i, 0, grid);
            }
        }

        // last col
        for(int i = 1 ; i < r - 1; i++){
            if(grid[i][c-1] == 1 && !visitedArr[i][c-1]) {
                dfsTravelAndMark(i, c-1, grid);
            }
        }

        for(int i = 1; i < r-1; i++) {
            for (int j = 1; j < c - 1; j++) {
                if(grid[i][j] == 1 && !visitedArr[i][j]){
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfsTravelAndMark(int r, int c, int[][] grid){
        int[] rows = {-1,1,0,0};
        int[] cols = {0,0,-1,1};
        grid[r][c] = 0;

        for(int k = 0; k < 4; k++){
            int rN = r + rows[k];
            int cN = c + cols[k];

            if(rN >= 0 && rN < grid.length && cN >= 0 && cN < grid[0].length && grid[rN][cN] == 1 ){
                dfsTravelAndMark(rN, cN, grid);
            }
        }
    }
}
