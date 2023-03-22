package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/29821/homework/problems/329?navref=cl_tt_nv
public class Flip01 {

    public static void main(String[] args) {
        System.out.println(flip("100100111101"));
    }

    static ArrayList<Integer> flip(String A) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = -1, end = 0;
        int startIdx = -1, endIdx = -1;
        while (end < A.length()) {
            int digit = A.charAt(end) == '0' ? 1 : -1;
            sum += digit;
            if (digit == 1 && start == -1) {
                start = end;
            }
            if (sum > maxSum) {
                maxSum = sum;
                endIdx = end;
                startIdx = start;
            }
            if (sum < 0) {
                start = -1;
                sum = 0;
            }
            end++;
        }
        if (startIdx == -1)
            return new ArrayList<>();

        return new ArrayList<>(Arrays.asList(new Integer[] { startIdx + 1, endIdx + 1 }));

    }

}
