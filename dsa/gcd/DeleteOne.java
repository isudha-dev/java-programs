package dsa.gcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DeleteOne {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 9, 18, 49, 12, 30 }))));
    }

    static int solve(ArrayList<Integer> A) {
        ArrayList<Integer> prefixGcd = new ArrayList<>();
        ArrayList<Integer> suffixGcd = new ArrayList<>(A.size());

        prefixGcd.add(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            prefixGcd.add(gcd(prefixGcd.get(i - 1), A.get(i)));
        }

        suffixGcd.add(A.get(A.size() - 1));
        int idx = 0;
        for (int i = A.size() - 2; i >= 0; i--) {
            suffixGcd.add(gcd(suffixGcd.get(idx), A.get(i)));
            idx++;
        }
        Collections.reverse(suffixGcd);

        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            int leftGcd = 0;
            int rightGcd = 0;
            if (i == 0) {
                rightGcd = suffixGcd.get(i + 1);
            } else if (i == A.size() - 1) {
                leftGcd = prefixGcd.get(A.size() - 2);
            } else {
                leftGcd = prefixGcd.get(i - 1);
                rightGcd = suffixGcd.get(i + 1);
            }
            max = Math.max(max, gcd(leftGcd, rightGcd));
        }

        return max;

    }

    static int gcdOfArr(ArrayList<Integer> arr) {
        if (arr.size() == 1) {
            return arr.get(0);
        }

        int firstNum = arr.get(0);
        arr.remove(0);
        return gcd(firstNum, gcdOfArr(arr));

    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);

    }

}
