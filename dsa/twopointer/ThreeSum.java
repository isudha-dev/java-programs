package dsa.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {

    public static int threeSumClosest(ArrayList<Integer> A, int B) {
        int n = A.size();
        Collections.sort(A);
        int minDiff = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i <= n - 3; i++) {
            int k = B - A.get(i);
            int p1 = i + 1, p2 = n - 1;

            while (p1 < p2) {
                if (A.get(p1) + A.get(p2) == k) {
                    return A.get(i) + A.get(p1) + A.get(p2);
                } else {
                    int diff = Math.abs(A.get(p1) + A.get(p2) - k);
                    if (diff < minDiff) {
                        minDiff = diff;
                        res = A.get(i) + A.get(p1) + A.get(p2);
                    }
                    if ((A.get(p1) + A.get(p2)) < k)
                        p1++;
                    else
                        p2--;
                }
            }
        }

        return res;
    }

    // -10 -9 -8 -7 -6 -5 -4 -3 -2 0 1 2 3 4 5 6 7 8 9 10
    public static void main(String[] args) {
        Integer[] arr = new Integer[] { -10, -9, -8, -7, -6, -5, -4, -3, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println(threeSumClosest(new ArrayList<Integer>(Arrays.asList(arr)), -1));
    }
}
