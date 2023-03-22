package primer;

public class TimeToEquality {
    // https://www.scaler.com/academy/mentee-dashboard/class/25549/homework/problems/9003?navref=cl_tt_nv
    public static void main(String[] args) {

        int[] A = { 2, 4, 1, 3, 2 };
        solve(A);
    }

    static int solve(int[] A) {
        int maxVal = 1;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            maxVal = Math.max(maxVal, A[i]);
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] < maxVal) {
                count += maxVal - A[i];
            }
        }

        return count;
    }
}
