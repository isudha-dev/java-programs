package interview.paypal;

import java.util.HashMap;

public class OnlineTest {
    public static void main(String[] args) {
        System.out.println(countSubstrings("asdf"));
    }
    public static int countSubstrings(String input_str) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 1);
        map.put('c', 2);
        map.put('d', 2);
        map.put('e', 2);
        map.put('f', 3);
        map.put('g', 3);
        map.put('h', 3);
        map.put('i', 4);
        map.put('j', 4);
        map.put('k', 4);
        map.put('l', 5);
        map.put('m', 5);
        map.put('n', 5);
        map.put('o', 6);
        map.put('p', 6);
        map.put('q', 6);
        map.put('r', 7);
        map.put('s', 7);
        map.put('t', 7);
        map.put('u', 8);
        map.put('v', 8);
        map.put('w', 8);
        map.put('x', 9);
        map.put('y', 9);
        map.put('z', 9);

        int n = input_str.length();
        int[] ans = new int[n];

        int idx = 0;
        for(char c: input_str.toCharArray()) {
            ans[idx++] = map.get(c);
        }

        int count = 0;
        for(int i = 2; i<= n; i++) {
            int sum = 0;
            for(int j = 0; j < i; j++) {
                sum += ans[j];
            }
            if(sum % i == 0) {
                count++;
            }
            int p2 = i;
            while(p2 < n) {
                sum -= ans[p2-i];
                sum += ans[p2];
                if(sum % i == 0) {
                    count++;
                }
                p2++;
            }
        }

        return count+n;

    }
}
