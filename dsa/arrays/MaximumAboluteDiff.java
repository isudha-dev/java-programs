package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.scaler.com/academy/mentee-dashboard/class/29819/assignment/problems/356?navref=cl_tt_nv

public class MaximumAboluteDiff {
    public static void main(String[] args) {
        System.out.println(maxArr(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 3, -1 }))));
    }

    static int maxArr(ArrayList<Integer> A) {
        ArrayList<Integer> case1 = new ArrayList<>(); // A[i]-i
        ArrayList<Integer> case2 = new ArrayList<>(); // A[i]+i

        for (int i = 0; i < A.size(); i++) {
            case1.add(A.get(i) - i);
            case2.add(A.get(i) + i);
        }

        // find max & min in new dsa.arrays
        Integer maxCase1 = Integer.MIN_VALUE, minCase1 = Integer.MAX_VALUE, maxCase2 = Integer.MIN_VALUE,
                minCase2 = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {
            maxCase1 = Math.max(maxCase1, case1.get(i));
            minCase1 = Math.min(minCase1, case1.get(i));
            maxCase2 = Math.max(maxCase2, case2.get(i));
            minCase2 = Math.min(minCase2, case2.get(i));
        }

        int ans = Math.max(maxCase1 - minCase1, maxCase2 - minCase2);

        return ans;
    }

}
