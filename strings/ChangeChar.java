package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeChar {

    // https://www.scaler.com/academy/mentee-dashboard/class/25563/homework/problems/9114/submissions
    public static void main(String[] args) {
        System.out.println(solve("abcbcfbcbbecabbbcd", 3));
    }

    static int solve(String A, int B) {
        int idx = 0;
        HashMap<String, Integer> hm = new HashMap<>();

        while (idx < A.length()) {
            String s = A.substring(idx, idx + 1);
            if (hm.containsKey(s)) {
                int freq = hm.get(s);
                hm.put(s, freq + 1);
            } else {
                hm.put(s, 1);
            }
            idx++;
        }

        List<Integer> lst = new ArrayList<>();
        for (Map.Entry<String, Integer> en : hm.entrySet()) {
            lst.add(en.getValue());
        }

        Collections.sort(lst);
        idx = 0;
        int sum = 0;
        while (idx < lst.size()) {
            sum += lst.get(idx);
            if (sum > B) {
                break;
            }
            idx++;
        }

        return lst.size() - idx;
    }
}
