package dsa.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class IsAlpha {

    public static void main(String[] args) {

        System.out.println(
                solve(new ArrayList<Character>(Arrays.asList(new Character[] { 'S', 'c', '9', '1', 't' }))));

    }

    static int solve(ArrayList<Character> A) {
        for (int i = 0; i < A.size(); i++) {
            System.out.println("Char: " + A.get(i));
            if ((!('a' <= A.get(i) && A.get(i) <= 'z')) && (!('A' <= A.get(i) && A.get(i) <= 'Z'))
                    && (!('0' <= A.get(i) && A.get(i) <= '9'))) {
                return 0;
            }
        }
        return 1;
    }

}