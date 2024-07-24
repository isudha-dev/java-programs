package interview.synopsys;

import java.util.HashMap;
import java.util.Map;

// Task 1
public class LengthOfShortestUniqueSubstring {

    public static int lengthOfShortestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<String, Integer> substringCount = new HashMap<>();

        // Generate all substrings and count their occurrences
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
            }
        }

        int minLength = Integer.MAX_VALUE;

        // Find the shortest substring that occurs exactly once
        for (Map.Entry<String, Integer> entry : substringCount.entrySet()) {
            if (entry.getValue() == 1) {
                minLength = Math.min(minLength, entry.getKey().length());
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        String input = "aabbbabaaa";
        int result = lengthOfShortestUniqueSubstring(input);
        System.out.println("The length of the shortest unique substring is: " + result);
    }
}

