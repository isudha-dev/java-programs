package dsa.contest.july08.CM2;

public class MinSumPath {

    public static void main(String[] args) {
        int[][] A = {{1,3,2},{4,3,1},{5,6,1}};
        minPathSum(A);
    }

    public static int minPathSum(int[][] A) {
        int i = A.length;
        int j = A[0].length;

        if(i==1 && j==1){
            return A[0][0];
        }

        int dp[][] = new int[i][j];

        for(int q = j-1; q >= 0; q--){
            for(int p = i-1; p >= 0; p--){
                dp[p][q] = -1;
            }
        }

        for(int q = 1; q < j; q++){
            dp[0][q] = dp[0][q-1] + A[0][q];

        }

        for(int p = 1; p < i; p++){
            dp[p][0] = dp[p-1][0] + A[p][0];
        }

        return calc(A, i-1, j-1, dp);
    }

    public static int calc(int[][] A, int i, int j, int[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        dp[i][j] = A[i][j] + Math.min(calc(A, i-1, j, dp), calc(A, i, j-1, dp));
        return dp[i][j];

    }

}
