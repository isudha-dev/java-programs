package dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class ReplicatingSubstring {

    public static void main(String[] args) {
        System.out.println(solve(2, "bbaa"));
    }

    public static int solve(int A, String B) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for (Character c : B.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        boolean seqPossible = true;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            int freq = entry.getValue();
            if (freq % A != 0) {
                seqPossible = false;
                break;
            }
        }

        return seqPossible ? 1 : -1;
    }

}
