package dsa.combinatorics;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortedPermRank {

    public static void main(String[] args) {
        System.out.println(findRank("baa"));
    }

    static int findRank(String A) {
        int mod = 1000003;
        List<Character> arr = A.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Collections.sort(arr);
        int n = A.length();
        int pos = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (ch == arr.get(0)) {
                pos++;
                arr.remove(0);
            } else {
                int multipler = 1;
                for (int j = 1; j < arr.size(); j++) {
                    if (ch != arr.get(j)) {
                        multipler++;
                    } else {
                        pos++;
                        arr.remove(j);
                        break;
                    }
                }
                long fact = 1;
                for (int k = 1; k <= (n - pos); k++) {
                    fact = ((long) fact * k) % mod;
                }
                fact = ((long) fact * multipler) % mod;
                sum += fact;
            }

        }

        return (int) (sum % mod) + 1;
    }

}
