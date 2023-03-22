package dsa.strings;

import java.util.HashMap;

public class WindowString {

    public static void main(String[] args) {
        minWindow1(
                "0mJdGXwLm9AOZ5xA8u92KDYqGJroQ537hoRXjQoUCMOpDYwxoNjexJGWQJAIxSFF3ZbIe27oFxUTJxtv8mORwpuRZn30MDj3kXRW2Ix3lslj7kwmGZPXAKhBW4q5T2BzsqbL0ZETFqRdxVm8GCGfqshvpWzsRvprUcF9vw3VlftqTRzKRzr4zYB2P6C7lg3I7EhGMPukUj8XGGZTXqPqnCqes",
                "rsm2ty04PYPEOPYO5");
    }

    public static String minWindow(String A, String B) {

        int head = 0, tail = 0, total = 0;
        int bLen = B.length();

        int[] bFreq = new int[58];
        for (Character c : B.toCharArray()) {
            int idx = c - 'A';
            if (idx >= 0 && idx <= 57)
                bFreq[idx]++;
        }

        int idx = 0;
        while (tail < A.length()) {
            tail = idx;
            for (Character c : B.toCharArray()) {
                if (A.charAt(idx) == c) {
                    bFreq[c - 'A']--;
                    total++;
                    break;
                }
            }
            if (total > bLen) {
                int tempIdx = head;
                boolean cont = true;
                while (tempIdx < tail && cont) {
                    for (Character c : B.toCharArray()) {
                        if (A.charAt(tempIdx) == c) {
                            int freq = bFreq[c - 'A'];
                            if (freq < 0) {
                                tempIdx++;
                                total--;
                            } else {
                                cont = false;
                            }
                            break;
                        }
                    }
                    // tempIdx++;
                }
                head = tempIdx;
            }
            idx++;
        }

        return A.substring(head, tail);
    }

    public static String minWindow1(String A, String B) {
        int head = 0, tail = 0, total = 0;
        int bLen = B.length();

        HashMap<Character, Integer> bFreq = new HashMap<>();
        for (Character c : B.toCharArray()) {
            bFreq.put(c, bFreq.getOrDefault(c, 0) + 1);
        }

        while (tail < A.length()) {
            Character c = A.charAt(tail);
            if (bFreq.containsKey(c)) {
                bFreq.put(c, bFreq.getOrDefault(c, 0) - 1);
                if (bFreq.get(c) >= 0)
                    total++;
            }

            while (total == 0) {
                head++;
            }

            if (total > bLen) {
                for (int i = head; i < tail; i++) {
                    Character a = A.charAt(i);
                    if (!bFreq.containsKey(a)) {
                        head++;
                        continue;
                    } else {
                        int freq = bFreq.get(a);
                        if (freq < 0) {
                            bFreq.put(a, bFreq.getOrDefault(a, 0) + 1);
                            head++;
                        } else
                            break;
                    }
                }
            }
            tail++;
        }

        if (total < bLen) {
            return "";
        }

        return A.substring(head, tail);
    }
}
