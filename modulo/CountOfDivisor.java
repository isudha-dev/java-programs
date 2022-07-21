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
            if (primeNums.contains(i)) {
                divisors.add(2);
                continue;
            }
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

    static int[] solve(int[] A) {
        int max = A[0];

        // Calculate max to initialize divisor array of max length
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

        int[] divisor_array = new int[max + 1];
        divisor_array[1] = 1; // Setting number of divisor of 1 as 1

        // Setting initial divisors as 2 as all numbers will have at least 2 divisors
        // i.e. 1 and itself
        for (int j = 2; j < divisor_array.length; j++) {
            divisor_array[j] = 2;
        }

        // incrementing the number of divisors for each multiples of numbers
        for (int k = 2; k < divisor_array.length; k++) {

            for (int l = k + k; l < divisor_array.length; l += k) {
                divisor_array[l] += 1;
            }
        }

        // Fetching the values of numbers in array directly from divisor_array into the
        // output array
        for (int c = 0; c < A.length; c++) {
            A[c] = divisor_array[A[c]];
        }

        return A;
    }

}
