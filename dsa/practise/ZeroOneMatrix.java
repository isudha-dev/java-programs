package dsa.practise;
//https://leetcode.com/problems/01-matrix/

import java.util.Arrays;

/*
        0 1 1 0 0
        0 0 0 0 0
        1 1 1 1 1
        1 0 1 1 1

        0 1 1 0 0
        0 0 0 0 0
        1 1 1 1 1
        1 0 1 2 2
 */
public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        int range = n*m;

        // first pass -> top->right->bottom
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(mat[r][c] == 0){
                    dp[r][c] = 0;
                } else {
                    int upCell = r > 0 ? dp[r-1][c] : range;
                    int leftCell = c > 0 ? dp[r][c-1] : range;
                    dp[r][c] = Math.min(upCell, leftCell) + 1;
                }
            }
        }

        // second pass -> bottom->left->top
        for(int r = n-1 ; r >= 0; r--){
            for(int c = m-1; c >= 0; c--){
                if(mat[r][c] == 0){
                    dp[r][c] = 0;
                } else {
                    int downCell = r < n-1 ? dp[r+1][c] : range;
                    int rightCell = c < m-1 ? dp[r][c+1] : range;
                    dp[r][c] = Math.min(Math.min(downCell, rightCell) + 1, dp[r][c]);
                }
            }
        }

        return dp;
    }

}
