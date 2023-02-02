package practise;

public class SpecialIndex {

    public static void main(String[] args) {
        int i = isSpecialIndex(new int[] { 1, 2, 3, 7, 1, 2, 3 });
        System.out.println(i);
    }

    public static int isSpecialIndex(int[] nums) {
        int n = nums.length;
        int[] pse = pse(nums);
        int[] pso = pso(nums);
        int count = 0;

        if (pso[n - 1] == (pse[n - 1] - nums[0]))
            return count++;

        for (int i = 1; i < n; i++) {
            int sEven = pse[i - 1] + pso[n - 1] - pso[i];
            int sOdd = pso[i - 1] + pse[n - 1] - pse[i];
            if (sEven == sOdd)
                return count++;
        }

        return count;
    }

    public static int[] pso(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) // odd
                ans[i] = ans[i - 1] + nums[i];
            else
                ans[i] = ans[i - 1];
        }
        return ans;
    }

    public static int[] pse(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) // even
                ans[i] = ans[i - 1] + nums[i];
            else
                ans[i] = ans[i - 1];
        }
        return ans;
    }

}
