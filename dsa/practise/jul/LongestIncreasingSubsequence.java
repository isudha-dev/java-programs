package dsa.practise.jul;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int ways[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(ways, 1);

        int maxi = 1;
        for(int i = 0; i < n; i++){
            for(int j = i - 1 ; j >=0 ; j--){
                if(nums[i] > nums[j]){
                    if(dp[i] == dp[j]+1){
                        ways[i] += ways[j];
                    }
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j] + 1;
                        ways[i] = ways[j];
                    }
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxi){
                ans += ways[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[] {1,2,4,3,5,4,7,2}));
    }

}
