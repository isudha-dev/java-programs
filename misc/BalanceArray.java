public class BalanceArray {

    public static void main(String[] args) {
        int[] arr = { 5, 5, 2, 5, 8 };

        System.out.println(solve(arr));
    }

    static int solve(int[] A) {

        int count = 0;
        int n = A.length;

        int[] pso = getPrefixSumArray(A, true, false);
        int[] pse = getPrefixSumArray(A, false, true);

        int sumEvenIdx = 0;
        int sumOddIdx = 0;
        int sumEvenIdxRight = 0;
        int sumEvenIdxLeft = 0;
        int sumOddIdxRight = 0;
        int sumOddIdxLeft = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sumEvenIdxLeft = 0;
                sumOddIdxLeft = 0;

            } else {
                sumEvenIdxLeft = getSumOfPSRange(pse, 0, i - 1);
                sumOddIdxLeft = getSumOfPSRange(pso, 0, i - 1);
            }
            sumEvenIdxRight = getSumOfPSRange(pse, i + 1, n - 1);
            sumOddIdxRight = getSumOfPSRange(pso, i + 1, n - 1);
            sumEvenIdx = sumEvenIdxLeft + sumOddIdxRight;
            sumOddIdx = sumOddIdxLeft + sumEvenIdxRight;

            if (sumEvenIdx == sumOddIdx)
                count++;
        }

        return count;
    }

    static int[] getPrefixSumArray(int[] arr, boolean odd, boolean even) {
        int n = arr.length;

        int[] ps = new int[n];
        int[] pse = new int[n];
        int[] pso = new int[n];

        if (arr.length != 0) {
            if (odd) {
                pso[0] = 0;
                for (int i = 1; i < n; i++) {
                    if (i % 2 == 0) {
                        pso[i] = pso[i - 1];
                    } else {
                        pso[i] = pso[i - 1] + arr[i];
                    }
                }
            } else if (even) {
                pse[0] = arr[0];
                for (int i = 1; i < n; i++) {
                    if (i % 2 == 0) {
                        pse[i] = pse[i - 1] + arr[i];
                    } else {
                        pse[i] = pse[i - 1];
                    }
                }
            } else {
                ps[0] = arr[0];
                for (int i = 1; i < n; i++) {
                    ps[i] = ps[i - 1] + arr[i];
                }
            }
        }

        if (odd)
            return pso;
        else if (even)
            return pse;
        else
            return ps;

    }

    static int getSumOfPSRange(int[] ps, int start, int end) {
        if (start == 0) {
            return ps[end];
        }

        return ps[end] - ps[start - 1];

    }

}
