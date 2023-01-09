import java.util.Arrays;

public class Find132Pattern {

    // Incomplete code

    /*
     * [1,2,3,4] F
     * [3,1,4,2] T
     * [-1,3,2,0] T
     * [1, 0, 1, -4, -3] F
     * [3,5,0,3,4] T
     */
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[] { 1, 2, 3, 5, 0, 3, 4, 2 }));
    }

    static boolean find132pattern(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(nums[i - 1], arr[i - 1]);
        }

        for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
            if (nums[j] <= arr[j])
                continue;
            while (top < nums.length && arr[top] <= arr[j])
                top++;
            if (top < nums.length && nums[j] > arr[top])
                return true;
            arr[--top] = nums[j];
        }

        return false;
    }

}
