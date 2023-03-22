package dsa.arrayrotation;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int n = nums.length;
        int k = 1;

        // approach 3
        int g = gcd(n, k);
        int temp, i, j, d;
        for (i = n - 1; i >= n - g; i--) {
            temp = nums[i];
            j = i;
            while (true) {
                d = j - k;
                while (d < 0)
                    d = n + d;
                if (d == i)
                    break;
                nums[j] = nums[d];
                j = d;
            }
            nums[j] = temp;

        }

        System.out.println(nums);

    }

    static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }

    }

}
