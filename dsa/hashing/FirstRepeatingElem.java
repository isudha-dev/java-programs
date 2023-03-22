package dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FirstRepeatingElem {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 6, 10, 5, 4, 9, 120 }))));
    }

    static int solve(ArrayList<Integer> A) {
        int ans = -1;
        int minIdx = Integer.MAX_VALUE;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            if (hm.containsKey(A.get(i))) {
                int idx = hm.get(A.get(i));
                if (idx < minIdx) {
                    minIdx = idx;
                    ans = A.get(i);
                }
            } else {
                hm.put(A.get(i), i);
            }
        }

        return ans;
    }

}
