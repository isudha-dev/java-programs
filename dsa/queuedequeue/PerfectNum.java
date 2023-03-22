package dsa.queuedequeue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNum {

    public static void main(String[] args) {
        System.out.println(solve(2));
    }

    public static String solve(int A) {

        Queue<String> q = new LinkedList<>();
        q.add("11");
        q.add("22");

        while (A > 1) {
            String str = q.peek();
            int size = str.length();

            String s1 = str.substring(0, size / 2);
            String s2 = str.substring(size / 2, size);

            q.add(s1 + "11" + s2);
            q.add(s1 + "22" + s2);

            q.remove();
            A--;

        }

        return q.peek();
    }

}
