package dsa.primer;

public class CountElementGreaterThanItself {
    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 9, 4, 5, 6, 9, 7, 6, 8, 9, 9 };

        if (nums.length == 0) {
            System.out.println(0);
        } else {
            int max = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    count = 1;
                } else if (nums[i] == max) {
                    count++;
                }
            }
            System.out.println(nums.length - count);
        }

    }

}