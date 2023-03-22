package dsa.twopointer;

public class MinimizeAbsDiff {

    public int solve(int[] A, int[] B, int[] C) {
        int ans = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < A.length && p2 < B.length && p3 < C.length) {
            int temp = Math.max(Math.max(A[p1], B[p2]), C[p3]) - Math.min(Math.min(A[p1], B[p2]), C[p3]);
            ans = Math.min(ans, temp);
            int min = Math.min(Math.min(A[p1], B[p2]), C[p3]);
            if (min == A[p1])
                p1++;
            else if (min == B[p2])
                p2++;
            else
                p3++;
        }

        return ans;
    }

}
