package dsa.gcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class AllGcdPair {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(
                new Integer[] { 1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1, 11 }))));
    }

    static ArrayList<Integer> solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> gcdList = new HashMap<>();
        ArrayList<Integer> orgList = new ArrayList<>();

        Collections.sort(A, Collections.reverseOrder());
        for (Integer x : A) {
            if (gcdList.getOrDefault(x, 0) > 0) {
                gcdList.put(x, gcdList.get(x) - 1);
            } else {
                for (Integer y : orgList) {
                    gcdList.put(gcd(x, y), gcdList.getOrDefault(gcd(x, y), 0) + 2);
                }
                orgList.add(x);
            }
        }

        return orgList;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
