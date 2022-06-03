package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumInWindow {
    // https://www.scaler.com/academy/mentee-dashboard/class/25581/assignment/problems/333?navref=cl_tt_nv

    public static void main(String[] args) {
        System.out.println(dNums(new ArrayList<>(Arrays.asList(new Integer[] { 1, 1, 2, 2 })), 1));
    }

    static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // creating hashset with first B elements of A
        for (int i = 0; i < B; i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }
        ans.add(map.size());

        // using sliding window technique to remove element and add another element/
        // adjust their frequencies
        for (int i = 0; i < A.size() - B; i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) - 1);
            if (map.get(A.get(i)) == 0) {
                map.remove(A.get(i));
            }
            map.put(A.get(i + B), map.getOrDefault(A.get(i + B), 0) + 1);
            ans.add(map.size());
        }

        return ans;
    }

}
