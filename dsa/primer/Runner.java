package dsa.primer;

public class Runner {
    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        int n = nums.length;
        int k = 9;
        int g = gcd(n, k);

        // Input: nums = [1,2,3,4,5,6,7], k = 3
        // Output: [5,6,7,1,2,3,4]
        // Explanation:
        // rotate 1 steps to the right: [7,1,2,3,4,5,6]
        // rotate 2 steps to the right: [6,7,1,2,3,4,5]
        // rotate 3 steps to the right: [5,6,7,1,2,3,4]
        // 7 6 5 4 3 2 1
        // 7 1 2 3 4 5 6
        // 6 5 4 3 2 1 7
        // 6 7 1 2 3 4 5

        // approach 1
        // for (int i = 0; i < k; i++) {
        // int temp = nums[n - 1];
        // for (int j = n - 2; j >= 0; j--) {
        // nums[j + 1] = nums[j];
        // }
        // nums[0] = temp;
        // }

        // approach 2
        int[] temp = new int[n];

        for (int j = 1; j <= g; j++) {
            int idx = 0;
            for (int i = n - 1; i >= 0; i--) {
                temp[idx] = nums[i];
                idx++;
            }
            for (int i = 1; i < n; i++) {
                temp[i] = nums[i - 1];
            }

        }

    }

    static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }

    }
}
