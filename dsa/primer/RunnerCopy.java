package dsa.primer;

public class RunnerCopy {
    public static void main(String[] args) {

        int[] nums = { -4, -1, 0, 3, 10 };
        int n = nums.length;

        int k; // position of first +ve num
        for (k = 0; k < n; k++) {
            if (nums[k] >= 0) {
                break;
            }
        }

        // squaring values
        for (int i = 0; i < n; i++) {
            int elem = nums[i];
            nums[i] = elem * elem;
        }

        int i = k - 1;
        int j = k;
        int[] temp = new int[n];
        int idx = 0;
        while (i >= 0 && j < n) {
            if (nums[i] < nums[j]) {
                temp[idx] = nums[i];
                i--;
            } else {
                temp[idx] = nums[j];
                j++;
            }
            idx++;
        }

        while (i >= 0) {
            temp[idx++] = nums[i--];
        }

        while (j < n) {
            temp[idx++] = nums[j++];
        }

        nums = temp.clone();

        System.out.println(nums);

        // need to check if no -ve num present

    }
}
