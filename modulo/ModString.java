package modulo;

import java.util.Arrays;

public class ModString {

    public static void main(String[] args) {
        System.out.println(findMod("43535321", 47));
    }

    // 599374528
    // 639045383

    static int findMod(String A, int B) {
        int n = A.length();

        String[] str = A.split("");
        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        long r = 1;
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans = (ans % B) + (((arr[i] % B) * (r % B)) % B);
            r = (r * 10 % B) % B;
        }

        return (int) ans % B;
    }

}
