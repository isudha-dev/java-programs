package binarysearch;

public class KthPrice {

    public static void main(String[] args) {
        KthPrice kp = new KthPrice();
        System.out.println(kp.solve(new int[] { 2, 1, 4, 3, 2 }, 3));
    }

    public int solve(final int[] A, int B) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i : A) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }

        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = countEqSmall(A, mid);
            if (count >= B) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int countEqSmall(int[] A, int C) {
        int count = 0;
        for (int i : A) {
            if (i <= C) {
                count++;
            }
        }
        return count;
    }

}
