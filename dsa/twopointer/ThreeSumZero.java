package dsa.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ThreeSumZero {

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for (int i = 0; i <= n - 3; i++) {
            int k = -1 * A.get(i);
            int p1 = i + 1, p2 = n - 1;

            while (p1 < p2) {
                if ((A.get(p1) + A.get(p2) - k) == 0) {
                    set.add(new ArrayList<>(Arrays.asList(new Integer[] { A.get(i), A.get(p1), A.get(p2) })));
                }
                if ((A.get(p1) + A.get(p2)) < k)
                    p1++;
                else
                    p2--;
            }
        }

        for (ArrayList<Integer> a : set) {
            ans.add(a);
        }

        return ans;
    }

    // [-5 0 5 ] [-5 1 4 ] [-4 -1 5 ] [-4 0 4 ] [-4 1 3 ] [-3 -2 5 ] [-3 -1 4 ] [-3
    // 0 3 ] [-2 -1 3 ] [-2 1 1 ] [-1 0 1 ] [0 0 0 ]
    public static void main(String[] args) {
        threeSum(new ArrayList<>(
                Arrays.asList(new Integer[] { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 })));
    }

}
