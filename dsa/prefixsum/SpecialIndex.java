package dsa.prefixsum;

public class SpecialIndex {

    public int specialIndexCount(int[] arr) {
        int count = 0;
        int[] pse = getPrefixSumEven(arr);
        int[] pso = getPrefixSumOdd(arr);

        for (int i = 0; i < arr.length; i++) {
            int sEven = sumInRange(pse, 0, i - 1) + sumInRange(pso, i + 1, arr.length - 1);
            int sOdd = sumInRange(pso, 0, i - 1) + sumInRange(pse, i + 1, arr.length - 1);
            if (sEven == sOdd)
                count++;
        }

        return count;
    }

    public int sumInRange(int[] arr, int s, int e) {
        if (s == 0)
            return arr[e];

        return arr[e] - arr[s - 1];
    }

    public int[] getPrefixSum(int[] arr) {
        int[] ans = new int[arr.length];

        ans[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans[i] = ans[i - 1] + arr[i];
        }

        return ans;
    }

    public int[] getPrefixSumEven(int[] arr) {

        int[] ans = new int[arr.length];

        ans[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((i ^ 2) == 1)
                ans[i] = ans[i - 1];
            else
                ans[i] = ans[i - 1] + arr[i];
        }

        return ans;
    }

    public int[] getPrefixSumOdd(int[] arr) {

        int[] ans = new int[arr.length];

        ans[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            if ((i ^ 2) == 0)
                ans[i] = ans[i - 1];
            else
                ans[i] = ans[i - 1] + arr[i];
        }

        return ans;
    }

}
