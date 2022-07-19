package primenum;

import java.util.ArrayList;

public class NumberOfOpenDoors {

    public static void main(String[] args) {
        System.out.println(solve1(484));
    }

    // 58854 284
    static int solve(int A) {
        int count = 0;
        ArrayList<Integer> factorsArra = noOfFactors(A);
        for (int i = 1; i <= A; i++) {
            int factors = factorsArra.get(i);
            if ((factors & 1) == 1) {
                count++;
            }

        }

        return count;
    }

    static ArrayList<Integer> noOfFactors(int A) {
        ArrayList<Integer> factorsArr = new ArrayList<>();
        for (int i = 1; i <= A + 1; i++) {
            factorsArr.add(1);
        }
        for (int i = 2; i <= A; i++) {
            for (int j = i; j <= A; j += i) {
                factorsArr.set(j, factorsArr.get(j) + 1);
            }
        }

        return factorsArr;
    }

    // only door which are perfect square will remain open
    static int solve1(int A) {
        if (A == 1)
            return 1;
        int count = 0;
        for (int i = 1; i * i <= A; i++) {
            if (i * i <= A) {
                count++;
            }
        }

        return count;
    }

}
