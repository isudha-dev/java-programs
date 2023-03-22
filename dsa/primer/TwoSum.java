package dsa.primer;

public class TwoSum {

    public static void main(String[] args) {
        // Input: numbers = [2,7,11,15], target = 9
        // Output: [1,2]

        int[] nums = { 2, 7, 11, 15 };
        int target = 22;

        int[] result = twoSum(nums, target);
        System.out.println(result);

    }

    static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int l, r;

        for (int i = 0; i < n - 1; i++) {

            l = i;
            r = binarySearch(numbers, target - numbers[l], i + 1, n - 1);
            if (r != -1)
                return new int[] { l + 1, r + 1 };

        }
        return new int[] { -1, -1 };

    }

    static int binarySearch(int nums[], int target, int start, int end) {

        int mid;
        if (start > end) {
            return -1;
        }
        mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, end);
        } else
            return binarySearch(nums, target, start, mid - 1);

    }

    static int findPosition(int nums[], int target, int start, int end) {

        int mid;
        if (start > end) {
            return start;
        }
        mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return findPosition(nums, target, mid + 1, end);
        } else
            return findPosition(nums, target, start, mid - 1);

    }

}
