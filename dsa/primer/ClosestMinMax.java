package dsa.primer;

public class ClosestMinMax {
    // https://www.scaler.com/academy/mentee-dashboard/class/25589/assignment/problems/986?navref=cl_tt_nv

    // Given an array A, find the size of the smallest dsa.subarray such that it
    // contains at least one occurrence of the maximum value of the array

    // and at least one occurrence of the minimum value of the array.
    public static void main(String[] args) {
        System.out.println(solve(new int[] { 1, 2, 6, 4, 7, 3, 2, 1, 6, 7 }));
    }

    static int solve(int[] A) {

        int ans = Integer.MAX_VALUE;
        int latestMax = -1;
        int latestMin = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : A) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == min) {
                latestMin = i;
                if (latestMax > -1) {
                    int len = latestMin - latestMax + 1;
                    if (len < ans)
                        ans = len;
                }
            }
            if (A[i] == max) {
                latestMax = i;
                if (latestMin > -1) {
                    int len = latestMax - latestMin + 1;
                    if (len < ans)
                        ans = len;
                }
            }
        }

        return ans;

    }

}
