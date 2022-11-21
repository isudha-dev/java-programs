package queuedequeue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IntegersWith123 {

    public static void main(String[] args) {
        System.out.println(solve(2));
    }

    public static ArrayList<Integer> solve(int A) {

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);

        int n = 3;
        while (ans.size() < A) {
            int x = q.peek();
            ans.add(x);
            q.remove();
            if (n >= A)
                continue;
            q.add(10 * x + 1);
            q.add(10 * x + 2);
            q.add(10 * x + 3);
            n += 3;
        }
        return ans;
    }

}
