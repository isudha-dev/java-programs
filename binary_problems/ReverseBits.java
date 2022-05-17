package binary_problems;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseBits {

    public static void main(String[] args) {

        int j = 3;
        System.out.println(reverse(j));

    }

    static long reverse(long A) {

        long res = 0;
        int currPow = 31;
        while (A > 0) {
            long remainder = A % 2;
            A /= 2;

            res += remainder << currPow--;
        }

        return res;

    }

    static ArrayList<Long> bitRepresentation(long A) {
        long division = A;
        long remainder;

        ArrayList<Long> bits = new ArrayList<>();

        while (division != 0) {
            remainder = division % 2;
            division = division / 2;
            bits.add(remainder);
        }

        Collections.reverse(bits);

        return bits;
    }

}
