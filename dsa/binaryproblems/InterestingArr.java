package dsa.binaryproblems;

// https://www.scaler.com/academy/mentee-dashboard/class/25555/homework/problems/1085?navref=cl_tt_nv

public class InterestingArr {

    public static void main(String[] args) {

        solve(new int[] { 1 });

    }

    static String solve(int[] A) {
        int num = A[0];
        for (int i = 1; i < A.length; i++) {
            num ^= A[i];
        }
        if ((num & 1) == 1) {
            return "No";
        } else {
            return "Yes";
        }

    }

}
