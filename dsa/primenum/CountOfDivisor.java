package dsa.primenum;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOfDivisor {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 20, 25 }))));
    }

    static ArrayList<Integer> solve(ArrayList<Integer> A) {

        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : A) {
            int ans = 0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    ans++;
                    if (j != i / j) {
                        ans++;
                    }
                }
            }
            res.add(ans);

        }
        return res;
    }

}
