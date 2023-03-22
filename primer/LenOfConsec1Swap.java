package primer;

import java.util.Arrays;

public class LenOfConsec1Swap {

    public static void main(String[] args) {
        System.out.println(solve("111000"));
    }

    static int solve(String A) {

        String[] str = A.split("");
        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int n = arr.length;
        int maxConsecutive1 = Integer.MIN_VALUE;
        int count_i = 0;
        for (int i : arr) {
            if (i == 1)
                count_i++;
        }

        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                left = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] == 1) {
                        left++;
                    } else
                        break;
                }

                right = 0;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] == 1) {
                        left++;
                    } else
                        break;
                }
                if (count_i > left + right) {
                    maxConsecutive1 = Math.max(maxConsecutive1, left + right + 1);
                } else {
                    maxConsecutive1 = Math.max(maxConsecutive1, left + right);
                }
            }

        }
        if (maxConsecutive1 == Integer.MIN_VALUE) {
            return n;
        }

        return maxConsecutive1;
    }

}
