package dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class CheckPalindrome {
    // https://www.scaler.com/academy/mentee-dashboard/class/25565/homework/problems/11859?navref=cl_tt_lst_nm
    public static void main(String[] args) {
        System.out.println(solve("a"));
    }

    static int solve(String A) {
        if (A.length() == 1) {
            return 1;
        }
        char[] ch = A.toCharArray();

        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : ch) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        int oddFrequencyElem = 0;

        for (Map.Entry<Character, Integer> en : hm.entrySet()) {
            if (en.getValue() % 2 == 0) {
                continue;
            } else {
                if (oddFrequencyElem == 0) {
                    oddFrequencyElem++;
                } else {
                    return 0;
                }
            }
        }

        return 1;
    }

}
