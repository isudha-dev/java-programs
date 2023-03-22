package primer;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 0, 0 };
        int n = nums.length;

        int i, j, k, temp, b;
        i = 0;
        b = n - 1;
        while (b != i) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            j = i;
            temp = nums[i];
            while (true) {

                k = j + 1;
                if (k == i || k < 0 || k == n) {
                    break;
                }
                nums[j] = nums[k];
                j = k;
            }
            nums[j] = temp;
            b--;
        }
        System.out.println(b);

    }

}
