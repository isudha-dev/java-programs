package primer;

public class RangeSumQuery {

    public static void main(String[] args) {

        System.out.println(rangeSum(new int[] { 1, 2, 3, 4, 5 }, new int[][] { { 1, 4 }, { 2, 3 } }));

    }

    static long[] rangeSum(int[] A, int[][] B) {
        int start, end;
        long[] result = new long[B.length];

        long[] ps = getPrefixSumArray(A);
        for (int i = 0; i < B.length; i++) {
            start = B[i][0];
            end = B[i][1];
            result[i] = getSumOfPSRange(ps, start - 1, end - 1);
        }
        return result;
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
