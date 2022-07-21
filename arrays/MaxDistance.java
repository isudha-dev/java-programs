package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistance {

    public static void main(String[] args) {
        System.out.println(maximumGap(new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 5, 4, 2 }))));
    }

    static int maximumGap(final List<Integer> A) {
        int n = A.size();

        int[] rmax = new int[n];
        rmax[n - 1] = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(A.get(i), rmax[i + 1]);
        }
        int x = 0;
        int y = 0;
        int ans = 0;

        while (x < n && y < n) {
            if (A.get(y) <= rmax[x]) {
                ans = Math.max(ans, x - y);
                x++;
            } else {
                y++;
            }
        }

        return ans;
    }

}
