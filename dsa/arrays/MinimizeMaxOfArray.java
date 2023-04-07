package dsa.arrays;

import java.util.Arrays;

public class MinimizeMaxOfArray {

    public static void main(String[] args) {
        System.out.println( solve(new int[] {13,13,20,0,8,9,9}));
    }

    public static int solve(int[] nums) {
        long prefixSum = nums[0], max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            prefixSum += nums[i];
            max = Math.max(max, (prefixSum/(i+1)));

        }
        return (int) max;
    }

    public int minimizeArrayValue(int[] nums) {
        int max = 0, prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            max = (int) Math.max(max, Math.ceil(prefixSum/ (i+1)));
        }

        return max;

    }

    public static int minimizeArrayValue1(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        } else if (n == 2) {
            return nums[0]>nums[1] ? nums[0] : nums[1];
        }

        int maxVal = Integer.MIN_VALUE, maxIndex = 0;

        boolean flag = true;

        while(flag) {
            maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (nums[i] > maxVal) {
                    maxVal = nums[i];
                    maxIndex = i;
                }
            }
            if(maxIndex == 0) {
                return maxVal;
            }
            int countMax = 0;
            for(int i = 0; i < n; i++){
                if(nums[i] == maxVal){
                    countMax++;
                }
            }
            if(countMax == n-1){
                flag = false;
            } else {
                nums[maxIndex] = nums[maxIndex] - 1;
                nums[maxIndex - 1] = nums[maxIndex - 1] + 1;
            }
        }

        return maxVal;

    }

}
