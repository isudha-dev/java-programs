package dsa.sorting;

import java.util.Map.Entry;
import java.util.TreeMap;

// https://www.scaler.com/academy/mentee-dashboard/class/29857/homework/problems/4808
public class SortArrayInGivenOrder {

    public static void main(String[] args) {
        SortArrayInGivenOrder sort = new SortArrayInGivenOrder();
        sort.solve(new int[] { 12, 7 }, new int[] { 7, 1, 6, 17, 2, 19, 10 });
    }

    public int[] solve(int[] A, int[] B) {
        TreeMap<Integer, Integer> freqA = new TreeMap<>();
        for (Integer i : A) {
            freqA.put(i, freqA.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[A.length];
        int idx = 0;

        for (Integer i : B) {
            if (freqA.containsKey(i)) {
                for (int k = 1; k <= freqA.get(i); k++) {
                    ans[idx] = i;
                    idx++;
                }
                freqA.remove(i);
            }

        }
        for (Entry<Integer, Integer> entry : freqA.entrySet()) {
            for (int k = 1; k <= entry.getValue(); k++) {
                ans[idx] = entry.getKey();
                idx++;
            }

        }
        return ans;
    }
}
