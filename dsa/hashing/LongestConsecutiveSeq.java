package dsa.hashing;

import java.util.HashSet;

public class LongestConsecutiveSeq {

    public static void main(String[] args) {
        int[] A = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
        LongestConsecutiveSeq lcs = new LongestConsecutiveSeq();
        System.out.println(lcs.longestConsecutive(A));
    }

    public int longestConsecutive(final int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : A) {
            set.add(i);
        }

        int ans = 1;

        for (int i : A) {

            if (set.contains(i - 1)) {
                continue;
            } else {
                int k = i;
                int len = 1;
                while (set.contains(k + 1)) {
                    k = k + 1;
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}
