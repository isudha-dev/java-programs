package dsa.strings;

import java.util.ArrayList;
import java.util.Collections;

public class BoringString {

    public static int solve(String A) {
        ArrayList<Character> odd = new ArrayList<>();
        ArrayList<Character> even = new ArrayList<>();

        for (Character c : A.toCharArray()) {
            if (c % 2 == 0) {
                even.add(c);
            } else {
                odd.add(c);
            }
        }
        Collections.sort(odd);
        Collections.sort(even);
        int oddLen = odd.size();
        int evenLen = even.size();

        if (Math.abs(odd.get(0) - even.get(evenLen - 1)) != 1)
            return 1;
        if (Math.abs(odd.get(oddLen - 1) - even.get(0)) != 1)
            return 1;

        return 0;
    }

}
