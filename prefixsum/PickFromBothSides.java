package prefixsum;

public class PickFromBothSides {

    public static void main(String[] args) {

        System.out.println(solve1(
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 5));
    }

    // approach 1: with O(N) TC, O(N) SC
    static int solve(int[] A, int B) {
        int n = A.length;
        long[] ps = getPrefixSumArray(A);

        int i = 0, j;
        long maxSum = Long.MIN_VALUE;
        long tempSum = 0;
        long sumL, sumR;

        while (i <= B) {
            j = B - i;
            if (i == 0) {
                sumL = 0;
            } else {
                sumL = getSumOfPSRange(ps, 0, i - 1);
            }
            if (j == 0) {
                sumR = 0;
            } else {
                sumR = getSumOfPSRange(ps, n - j, n - 1);
            }
            tempSum = sumL + sumR;
            maxSum = Math.max(maxSum, tempSum);

            i++;
        }
        return (int) maxSum;
    }

    static long[] getPrefixSumArray(int[] arr) {
        int n = arr.length;
        long[] ps = new long[n];

        if (n != 0) {

            ps[0] = arr[0];
            for (int i = 1; i < n; i++) {
                ps[i] = ps[i - 1] + arr[i];
            }
        }
        return ps;

    }

    static long getSumOfPSRange(long[] ps, int start, int end) {
        if (start == 0) {
            return ps[end];
        }
        return ps[end] - ps[start - 1];

    }

    // approach 2: with O(N) TC, O(1) SC, by adding 1 array element and removing 1
    // array element. so we wont need prefix sum array.
    static int solve1(int[] A, int B) {
        int n = A.length;

        int i = 1, j;
        long maxSum = Long.MIN_VALUE;
        long tempSum = 0;
        long sumL = 0, sumR = 0;

        for (int k = n - 1; k >= n - B; k--) {
            sumR += A[k];
        }

        tempSum = sumL + sumR;
        maxSum = Math.max(maxSum, tempSum);

        while (i <= B) {
            j = B - i;

            sumL = sumL + A[i - 1];
            sumR = sumR - A[n - j - 1];

            tempSum = sumL + sumR;
            maxSum = Math.max(maxSum, tempSum);

            i++;
        }
        return (int) maxSum;
    }

}

// -50293468
// -819
