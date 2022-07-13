package modulo;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOfDivisor {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(new Integer[] { 30, 36 }))));
    }

    static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int max = 0;
        for (int i : A) {
            max = Math.max(max, i);
        }

        ArrayList<Integer> divisors = new ArrayList<>();
        ArrayList<Integer> primeNums = sieveOfEratosthenes(max);

        for (Integer i : A) {
            int ans = 1;
            int temp = i;
            while (temp != 1) {
                int count = 1;
                int d = smallestPrimeFactor(temp, primeNums);
                while (temp != 1 && temp % d == 0) {
                    count++;
                    temp = temp / d;
                }
                ans *= count;
            }
            divisors.add(ans);

        }

        return divisors;
    }

    private static ArrayList<Integer> sieveOfEratosthenes(int n) {

        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = true;
                }
            }
        }

        ArrayList<Integer> primeNums = new ArrayList<>();
        int idx = 2;
        while (idx < arr.length) {
            if (!arr[idx]) {
                primeNums.add(idx);
            }
            idx++;

        }

        return primeNums;

    }

    private static int smallestPrimeFactor(int n, ArrayList<Integer> primeNums) {

        int ans = 1;
        for (Integer i : primeNums) {
            if (n % i == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }

}
