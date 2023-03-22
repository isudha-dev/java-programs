package dsa.binarysearch;

public class FoodPacketDist {

    public static void main(String[] args) {
        FoodPacketDist fp = new FoodPacketDist();
        System.out.println(fp.solve(new int[] { 2, 9, 5, 4 }, 13));
    }

    public int solve(int[] A, int B) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < A.length; i++) {
            high = Math.min(high, A[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(A, B, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        if (ans == -1) {
            return 0;
        } else {
            return ans;
        }
    }

    public boolean check(int[] A, int B, int mid) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (mid == 0) {
                sum += A[i];
            } else {
                sum += (A[i] / mid);
            }
        }
        return sum >= B;
    }

}
