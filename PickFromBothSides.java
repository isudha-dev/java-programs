public class PickFromBothSides {

    public static void main(String[] args) {

        System.out.println(solve(
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 5));
    }

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
            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
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

}

// -50293468
// -819
