package dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DiffIsK {
    // https://www.scaler.com/academy/mentee-dashboard/class/25581/assignment/problems/160?navref=cl_tt_nv
    public static void main(String[] args) {
        System.out.println(diffPossible(new ArrayList<>(Arrays.asList(new Integer[] { 77, 28, 19, 21, 67, 15, 53, 25,
                82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0 })), 53));
    }

    static int diffPossible(final List<Integer> A, int B) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            if (hs.contains(B + A.get(i)) || hs.contains(A.get(i) - B)) {
                return 1;
            } else {
                hs.add(A.get(i));
            }
        }

        return 0;
    }

}
