package dsa.primenum;

import java.util.ArrayList;

public class PrimeSum {

    public static void main(String[] args) {
        System.out.println(primesum(20000000));
    }

    static ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == 4) {
            ans.add(2);
            ans.add(2);
            return ans;
        }

        for (int i = 3; i < A; i += 2) {
            if (isPrime(i)) {
                int j = A - i;
                if (isPrime(j)) {
                    ans.add(i);
                    ans.add(j);
                    break;
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
