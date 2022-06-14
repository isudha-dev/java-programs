package leetcode;

import java.util.HashMap;

// https://leetcode.com/problems/maximum-erasure-value/
public class MaxErasureVal {

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[] { 5, 2, 1, 2, 5, 2, 1, 2, 5 }));
    }

    static int maximumUniqueSubarray(int[] nums) {

        int n = nums.length;
        int ansSum = Integer.MIN_VALUE;

        int l = 0, r = 0, sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (r < n) {
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
            sum += nums[r];
            while (hm.get(nums[r]) > 1 && l < r) {
                hm.put(nums[l], hm.getOrDefault(nums[l], 0) - 1);
                sum -= nums[l];
                l++;
            }
            ansSum = Math.max(ansSum, sum);
            r++;
        }

        return ansSum;
    }

}
