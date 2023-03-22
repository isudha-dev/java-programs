package dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayInAP {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 4, 1 }))));
    }

    static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int min1 = A.get(0);
        int min2 = A.get(1);
        int diff = min2 - min1;

        for (int i = 2; i < A.size(); i++) {
            int diffLocal = A.get(i) - A.get(i - 1);
            if (diffLocal != diff) {
                return 0;
            }
        }

        return 1;

    }

}
