package dsa.primenum;

import java.util.ArrayList;
import java.util.HashSet;

public class LuckyNum {

    public static void main(String[] args) {
        System.out.println(solve(50000));

    }

    static int solve(int A) {
        int count = 0;
        if (A <= 5) {
            return 0;
        }
        ArrayList<Integer> spfArr = generateSpfArray(A);
        for (int i = 6; i <= A; i++) {
            if (isPrime(i)) {
                continue;
            }
            int temp = i;
            int spf = spfArr.get(i);
            HashSet<Integer> primeFactor = new HashSet<Integer>();
            while (temp != 1) {
                primeFactor.add(spf);
                temp = temp / spf;
                spf = spfArr.get(temp);
            }
            if (primeFactor.size() == 2) {
                count++;
            }
        }

        return count;
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

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
