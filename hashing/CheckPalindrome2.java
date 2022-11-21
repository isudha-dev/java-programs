package hashing;

import java.util.HashMap;
import java.util.Map.Entry;

public class CheckPalindrome2 {

    public static void main(String[] args) {
        CheckPalindrome2 cp = new CheckPalindrome2();
        System.out.println(cp.solve("abbaee"));
    }

    public int solve(String A) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : A.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count1 = 0;// count2 = 0;

        for (Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if ((count & 1) != 1) {
                // count2++;
            } else {
                count1++;
            }
        }

        if (count1 > 1) {
            return 0;
        }
        return 1;
    }

}
