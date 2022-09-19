package queuedequeue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        System.out.println(solve("abadbc"));
    }

    public static String solve(String A) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        for (Character c : A.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                q.add(c);
            }
            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                q.remove();
            }
            if (!q.isEmpty()) {
                sb.append(q.peek());
            } else {
                sb.append("#");
            }
        }

        return sb.toString();
    }

}
