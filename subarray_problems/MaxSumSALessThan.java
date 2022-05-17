package subarray_problems;

public class MaxSumSALessThan {

    public static void main(String[] args) {

        System.out.println(maxSubarray(61, 8,
                new int[] { 34, 75, 69, 43, 8, 34, 54, 79, 7, 39, 64, 85, 37, 14, 50, 40, 78, 5, 98, 13, 89, 45, 30, 66,
                        50, 90, 28, 13, 64, 44, 78, 58, 94, 100, 65, 88, 69, 48, 41, 64, 56, 60, 100, 95, 96, 66, 11,
                        92, 32, 17, 65, 39, 42, 90, 37, 20, 21, 24, 93, 47, 26 }));
    }

    static int maxSubarray(int A, int B, int[] C) {

        int[] ps = new int[A];
        ps[0] = C[0];

        // o(n)
        for (int i = 1; i < A; i++) {
            ps[i] = ps[i - 1] + C[i];
        }

        int sum;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0, j; i < A; i++) { // n times
            j = i;
            sum = 0;
            while (sum < B && j < A) {
                sum = getPrefixSumRange(ps, i, j);
                if (sum > maxSum && sum <= B) {
                    maxSum = sum;
                }
                if (sum > B) {
                    break;
                }
                j++;
            }
            if (maxSum == B) {
                break;
            }
        }

        return (maxSum == Integer.MIN_VALUE) ? 0 : maxSum;

    }

    static int getPrefixSumRange(int[] ps, int s, int e) {
        if (s == 0) {
            return ps[e];
        }
        return ps[e] - ps[s - 1];
    }

}
