package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RainWaterTrapped {

    public static void main(String[] args) {
        trap(new ArrayList<Integer>(Arrays.asList(new Integer[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 })));
        // 0, 1, 0, 2
    }

    static int trap(final List<Integer> A) {
        int n = A.size();
        int max = 0;
        List<Integer> rightMax = new ArrayList<>();
        rightMax.add(max);

        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, A.get(i + 1));
            rightMax.add(max);
        }
        Collections.reverse(rightMax);

        int leftMax = A.get(0);
        int waterTrapped = 0;
        for (int i = 1; i < n; i++) {
            leftMax = Math.max(leftMax, A.get(i - 1));
            waterTrapped += Math.min(leftMax, rightMax.get(i)) - A.get(i);
        }

        return waterTrapped;
    }

}
