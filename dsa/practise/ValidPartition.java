package dsa.practise;

import java.util.Arrays;

//https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
public class ValidPartition {

    public static boolean validPartition(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return validIndex(n-1, nums, dp);
    }

    public static boolean validIndex(int ind, int[] nums, int[] dp){
        if(ind < 0){
            return true;
        }
        if(dp[ind] != -1){
            return dp[ind] == 1? true: false;
        }

        boolean firstCond = false;
        boolean secondCond = false;
        boolean thirdCond = false;

        if(ind >= 1 && nums[ind-1] == nums[ind]){
            firstCond = validIndex(ind-2, nums, dp);
        }
        if(ind >= 2 && nums[ind-1] == nums[ind] && nums[ind-1] == nums[ind - 2]){
            secondCond = validIndex(ind-3, nums, dp);
        }
        if(ind >= 2 && nums[ind] == nums[ind-1]+1 && nums[ind-1] == nums[ind-2]+1){
            thirdCond = validIndex(ind-3, nums, dp);
        }
        dp[ind] = (firstCond || secondCond || thirdCond) == true? 1: 0;

        return firstCond || secondCond || thirdCond;
    }

    public static void main(String[] args) {
        System.out.println(validPartition(new int[] {4,4,5,6}));
    }

}
