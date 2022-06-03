package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(
                twoSum(new ArrayList<>(Arrays.asList(new Integer[] { 2, 5, 0, -6, 7, -4, 0, 4, 3, 0, -2, 0, 9, -3, -9,
                        -3, 9, 3, 2, -10, -8, -3, -10, -5, 2, -8, 4, 5, 6, 7, -10, 4, -3, -10, 5, 4, 1, 5, 5, -3, -1,
                        -8, -3, -6, -7, -8, -8, -7, 0, -2, 7, 7, 10, -7, -7, 10, -4, 0, 0, -6, -5, -5, 0, 8, 4, 1, 4,
                        -1, -10, -4, -6, 10, -2, 9, -6, -3, -4, -1, 10, -9, -5, 10, -5, 8, 3 })), 0));
    }

    static ArrayList<Integer> twoSum(final List<Integer> A, int B) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(B - A.get(i))) {
                ans.add(i + 1);
                ans.add(map.get(B - A.get(i)));
                break;
            } else if (!map.containsKey(A.get(i))) {
                map.put(A.get(i), i + 1);
            }
        }
        Collections.sort(ans);
        return ans;
    }

}
