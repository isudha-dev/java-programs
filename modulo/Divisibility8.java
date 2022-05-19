package modulo;

import java.util.Arrays;

public class Divisibility8 {

    public static void main(String[] args) {
        System.out.println(solve("512"));
    }

    static int solve(String A) {
        int n = A.length();

        String[] str = A.split("");
        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        if (n >= 3) {
            int digitToCheck = arr[n - 3];
            int num = arr[n - 2] * 10 + arr[n - 1];
            if ((digitToCheck % 2 == 0) && (num % 8 == 0)) {
                return 1;
            } else if ((digitToCheck % 2 != 0) && ((num + 4) % 8 == 0)) {
                return 1;
            }
        } else if (n == 2) {
            int num = arr[n - 2] * 10 + arr[n - 1];
            return (num % 8 == 0) ? 1 : 0;

        } else {
            int num = arr[n - 1];
            return (num % 8 == 0) ? 1 : 0;
        }

        return 0;
    }

}
