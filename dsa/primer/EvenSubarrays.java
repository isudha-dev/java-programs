package dsa.primer;

public class EvenSubarrays {
    // https://www.scaler.com/academy/mentee-dashboard/class/25589/homework/problems/1176?navref=cl_tt_nv
    /*
     * You are given an integer array A.
     * 
     * Decide whether it is possible to divide the array into one or more subarrays
     * of even length such that the first and last element of all subarrays will be
     * even.
     * 
     * Return "YES" if it is possible; otherwise, return "NO" (without quotes).
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[] { 796, 483, 671, 998, 149, 374, 801, 191, 457, 802, 903, 329, 191, 286, 153,
                600, 917, 189, 724, 741, 306, 253, 520, 372 }));

    }

    static String solve(int[] A) {
        int n = A.length;

        if (n % 2 != 0 || A[0] % 2 != 0 || A[n - 1] % 2 != 0) {
            return "NO";
        } else {
            // for (int i = 1; i < n; i += 2) {
            // if (A[i] % 2 == 0 && A[i + 1] % 2 == 0) {
            // return "YES";

            // }
            return "YES";
        }

    }

}