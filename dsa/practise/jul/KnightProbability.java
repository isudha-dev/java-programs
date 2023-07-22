package dsa.practise.jul;

import java.util.Arrays;

public class KnightProbability {


    public static double knightProbability(int n, int k, int row, int column) {
        int[][] dir = new int[][]{{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        double[][][] dp = new double[k+1][n][n];
        dp[0][row][column] = 1;

        for(int K = 1; K<=k ; K++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int[] d : dir) {
                        int r = i - d[0];
                        int c = j - d[1];
                        if(r >=0 && r < n && c >= 0 && c < n) {
                            dp[K][i][j] += (dp[K-1][r][c]/8.0);
                        }
                    }
                }
            }
        }
        double ans = 0.0;
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                ans+=dp[k][i][j];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        knightProbability(3,2,0,0);
    }

}
