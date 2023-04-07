package dsa.graph;

public class NoOfClosedIslands {

    public static void main(String[] args) {
//        int[][] grid = new int[][] {{1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0}, {1,0,1,0,1,1,1,0}, {1,0,0,0,0,1,0,1}, {1,1,1,1,1,1,1,0}};

        int[][] grid = new int[][] {{0,0,1,1,0,1,0,0,1,0}, {1,1,0,1,1,0,1,1,1,0}, {1,0,1,1,1,0,0,1,1,0}, {0,1,1,0,0,0,0,1,0,1}, {0,0,0,0,0,0,1,1,1,0}, {0,1,0,1,0,1,0,1,1,1}, {1,0,1,0,1,1,0,0,0,1}, {1,1,1,1,1,1,0,0,0,0}, {1,1,1,0,0,1,0,1,0,1}, {1,1,1,0,1,1,0,1,1,0}};
        System.out.println("Closed islands: "+ closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visitedArr = new boolean[r][c];

        for(int i = 1 ; i < r - 1 ; i++){
            for(int j = 1; j < c - 1 ; j++){
                if(grid[i][j] == 0 && !visitedArr[i][j]){
                    if(DFSTravel(i, j, visitedArr, grid))
                        count++;
                }
            }
        }

        return count;
    }

    public static boolean DFSTravel(int i, int j, boolean[][] visitedArr, int[][] grid){
        int r = grid.length;
        int c = grid[0].length;

        if(i < 0 || i >= r || j < 0 || j >= c){
            return false;
        }

        if(visitedArr[i][j]) {
            return true;
        }

        visitedArr[i][j] = true;

        if(grid[i][j] == 1){
            return true;
        }

        int[] rows = {0,0,-1,1};
        int[] cols = {-1,1,0,0};

        boolean isClosed = true;
        for(int k = 0; k < 4; k++){
            int rN = i + rows[k];
            int cN = j + cols[k];

            isClosed &= DFSTravel(rN, cN, visitedArr, grid);

        }
        return isClosed;
    }

}
