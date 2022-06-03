package subarray_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubarrayWithSum {

    // https://www.scaler.com/academy/mentee-dashboard/class/25581/assignment/problems/4116?navref=cl_tt_nv
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(new Integer[] { 3, 7, 8, 9, 3, 3 })), 6));
        // 1 3 6 10 15
    }

    static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Long> ps = new ArrayList<>();
        int sum = 0;
        for (Integer i : A) {
            sum += i;
            ps.add((long) sum);
        }

        HashMap<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            Long ps0i = ps.get(i);
            if (ps0i == B) {
                return createAnsList(A.subList(0, i + 1));
            }
            if (hm.containsKey(ps0i - B)) {
                return createAnsList(A.subList(hm.get(ps0i - B) + 1, i + 1));
            } else {
                hm.put(ps0i, i);
            }
        }

        return new ArrayList<>(Arrays.asList(new Integer[] { -1 }));
    }

    static ArrayList<Integer> createAnsList(List<Integer> lst) {
        ArrayList<Integer> ansLst = new ArrayList<>();
        for (Integer i : lst) {
            ansLst.add(i);
        }
        return ansLst;
    }

}
