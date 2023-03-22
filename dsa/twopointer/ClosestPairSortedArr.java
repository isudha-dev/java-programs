package dsa.twopointer;

public class ClosestPairSortedArr {

    public static int[] solve(int[] A, int[] B, int C) {
        int p1 = 0, p2 = B.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;

        while (p1 < A.length && p2 >= 0) {
            int sum = A[p1] + B[p2];
            if (sum == C) {
                return new int[] { A[p1], B[p2] };
            } else {
                int diff = Math.abs(sum - C);
                if (diff < minDiff) {
                    minDiff = diff;
                    val1 = A[p1];
                    val2 = B[p2];
                } else if (diff == minDiff) {
                    if (A[p1] < val1) {
                        val1 = A[p1];
                        val2 = B[p2];
                    } else if (A[p1] == val1) {
                        if (B[p2] < val2)
                            val2 = B[p2];
                    }
                }
                if (sum > C)
                    p2--;
                else
                    p1++;
            }
        }
        return new int[] { val1, val2 };
    }

    public static void main(String[] args) {
        int[] A = { 1, 3, 5, 7, 9 };
        int[] B = { 2, 4, 6, 8, 10 };

        int[] a = solve(A, B, 10);
        System.out.println(a);
    }

}
