package dsa.twopointer;

public class Array3Pointer {

    public static int minimize(final int[] A, final int[] B, final int[] C) {
        int ans = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < A.length && p2 < B.length && p3 < C.length) {
            int temp = Math.max(Math.max(Math.abs(A[p1] - B[p2]), Math.abs(B[p2] - C[p3])), Math.abs(C[p3] - A[p1]));
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

    public static void main(String[] args) {
        int[] A = { 5, 10, 17, 20, 21, 24 };
        int[] B = { -1, 1, 9, 16, 18, 23, 25 };
        int[] C = { -8, -2, 6, 11, 15, 19, 25 };

        System.out.println(minimize(A, B, C));
    }

}
