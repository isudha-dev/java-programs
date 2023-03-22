package primer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MaxOperationsKPairs {

    public static void main(String[] args) {
        int[] nums = { 4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4 };
        System.out.println(maxOperations(nums, 2));
    }

    static int maxOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1, sum = 0;
        while (low < high) {
            sum = nums[low] + nums[high];
            if (sum > k)
                high--;
            else if (sum < k)
                low++;
            else {
                count++;
                low++;
                high--;
            }

        }

        return count;
    }

    static int maxOperationsHashMap(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            // to check if num is present and have some value
            if (map.containsKey(num) && map.get(num) > 0) {
                count++;
                map.put(num, map.get(num) - 1);
            } else {
                // getOrDefault is easy way it directly checks if value is 0 returns 0 where I
                // added 1
                // and if some value is present then it return that value "similar to
                // map.get(i)" and I added 1 on it
                map.put(k - num, map.getOrDefault(k - num, 0) + 1);
            }
        }
        return count;

    }

    static int maxOperationsTLE(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }

        List<Integer> intList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        int count = 0;
        int j;
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) != 0) {
                int temp = intList.get(i);
                intList.set(i, 0);
                if (intList.contains(k - temp) && temp != k) {
                    j = intList.indexOf(k - temp);
                    count++;
                    intList.set(j, 0);
                }
            }
        }

        return count;

    }

    /*
     * [4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4]
     * 2
     */

}
