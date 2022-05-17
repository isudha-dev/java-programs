package subarray_problems;

public class SubarraySum {

    public static void main(String[] args) {

        System.out.println(subarraySum(new int[] { 2, 1, 3 }));
    }

    static long subarraySum(int[] A) {
        int n = A.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) ((i + 1) * (n - i) * A[i]);
        }

        return sum;
    }

}
