package primenum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DistinctPrimeDivisor {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 96, 98, 5, 41, 80 }))));
    }

    // find distinct prime factorisation
    static int solve(ArrayList<Integer> A) {
        int max = 0;
        for (Integer i : A) {
            max = Math.max(max, i);
        }

        ArrayList<Integer> spfArr = generateSpfArray(max);
        HashSet<Integer> primeFactors = new HashSet<>();
        for (Integer i : A) {
            int temp = i;
            int spf = spfArr.get(i);
            while (temp != 1) {
                primeFactors.add(spf);
                temp = temp / spf;
                spf = spfArr.get(temp);
            }
        }

        return primeFactors.size();
    }

    static ArrayList<Integer> generateSpfArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            ans.add(-1);
        }
        for (int i = 2; i <= n; i++) {
            if (ans.get(i) == -1) {
                ans.set(i, i);
                for (long j = (long) i * i; j <= n; j += i) {
                    if (ans.get((int) j) == -1) {
                        ans.set((int) j, i);
                    }
                }
            }
        }
        return ans;
    }

}
