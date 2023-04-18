package dsa.dynamicprogramming;

import java.util.List;

public class MaximumValueOfKCoinsFromPilesLC {

    public static void main(String[] args) {

    }

    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        return dpFunc(0, k, piles, dp);
    }

    public static int dpFunc(int i, int k, List<List<Integer>> piles, int[][] dp){
        if(dp[i][k] > 0 ) return dp[i][k];
        if(i == piles.size() || k == 0) return 0;

        int res = dpFunc(i+1, k, piles, dp);
        int curr = 0;
        for(int j = 0; j < piles.get(i).size() && j < k ; ++j){
            curr += piles.get(i).get(j);
            res = Math.max(res, dpFunc(i+1, k-j-1, piles, dp) + curr);
        }
        dp[i][k] = res;

        return res;
    }
}
