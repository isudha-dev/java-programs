package dsa.hashing;

import java.util.HashMap;

// https://www.scaler.com/academy/mentee-dashboard/class/29857/assignment/problems/298?navref=cl_tt_lst_nm
public class LargestContSeq0Sum {

    public static void main(String[] args) {
        int[] A = new int[] { -19, 8, 2, -8, 19, 5, -2, -23 };
        lszero(A);
    }

    public static int[] lszero(int[] A) {

        int[] preSum = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            preSum[i] = sum;
        }

        int longestLen = 0;
        int startIdx = -1, endIdx = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < preSum.length; i++) {
            if (map.containsKey(preSum[i])) {
                int firstOcc = map.get(preSum[i]);
                int newLen = i - firstOcc;
                if (newLen > longestLen) {
                    longestLen = newLen;
                    startIdx = firstOcc + 1;
                    endIdx = i;
                }
            } else {
                map.put(preSum[i], i);
            }
        }

        if (longestLen == 0) {
            return new int[] {};
        }

        int[] ans = new int[longestLen];
        int idx = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            ans[idx] = A[i];
            idx++;
        }

        return ans;
    }

}
