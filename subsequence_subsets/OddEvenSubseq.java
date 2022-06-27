package subsequence_subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class OddEvenSubseq {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 5, 2, 9, 12 }))));
    }

    static int solve(ArrayList<Integer> A) {
        int len = 0;
        boolean isOdd = (A.get(0) & 1) != 1 ? false : true;

        for (Integer i : A) {
            if ((i & 1) == 1 && isOdd) {
                len++;
                isOdd = false;
            } else if ((i & 1) != 1 && !isOdd) {
                len++;
                isOdd = true;
            }
        }

        return len;

    }

}
