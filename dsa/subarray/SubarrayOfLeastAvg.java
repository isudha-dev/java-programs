package dsa.subarray;

public class SubarrayOfLeastAvg {

    public static void main(String[] args) {
        System.out.println(solve(new int[] { 3, 7, 5, 20, -10, 0, 12 }, 2));
    }

    static int solve(int[] A, int B) {
        int n = A.length;
        int idx = 0;
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }
        int minSum = sum;
        for (int i = 1; i <= n - B; i++) {
            sum += A[i - 1 + B] - A[i - 1];
            if (sum < minSum) {
                minSum = sum;
                idx = i;
            }
        }

        return idx;
    }

    static int subArraySum(int[] A, int s, int e) {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += A[i];

        }

        return sum;
    }

}
