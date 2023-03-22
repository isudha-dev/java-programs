package dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PairsWithXOR {

    // https://www.scaler.com/academy/mentee-dashboard/class/25581/homework/problems/10640?navref=cl_tt_nv
    public static void main(String[] args) {
        Integer[] num = new Integer[] { 5, 4, 10, 15, 7, 6, 10 };
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(num)), 5));

    }

    static int solve(ArrayList<Integer> A, int B) {
        HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (hs.contains(B ^ A.get(i))) {
                count++;
            }
            hs.add(A.get(i));

        }

        return count;
    }

}
