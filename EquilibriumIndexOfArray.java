public class EquilibriumIndexOfArray {

    public static void main(String[] args) {

        System.out.println(solve(new int[] { 1, 2, 3 }));
    }

    static int solve(int[] A) {

        int n = A.length;
        int[] ps = getPrefixSumArray(A, false, false);
        int sumL = 0;
        int sumR = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sumL = 0;
            } else {
                sumL = getSumOfPSRange(ps, 0, i - 1);
            }
            sumR = getSumOfPSRange(ps, i + 1, n - 1);
            if (sumL == sumR) {
                return i;
            }

        }

        return -1;
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
