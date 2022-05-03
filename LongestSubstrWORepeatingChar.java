import java.util.HashMap;

public class LongestSubstrWORepeatingChar {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        HashMap<String, Integer> strHash = new HashMap<>();
        int i = 1, j = 0, len = 0, tempLen, idx;
        String[] ss = s.split("");
        for (Integer k = 0; k < ss.length; k++) {
            if (!strHash.containsKey(ss[k])) {
                strHash.put(ss[k], k);
            } else {
                idx = strHash.get(ss[k]);
                i = (idx + 2 < i) ? i : idx + 2;
                strHash.put(ss[k], k);
            }
            j += 1;
            tempLen = j - i + 1;
            len = Math.max(len, tempLen);
        }
        return len;
    }

}
