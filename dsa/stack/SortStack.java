package dsa.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(
                Arrays.asList(new Integer[] { 92, 16, 9, 43, 2, 17, 100, 52, 69, 12, 78, 62, 5, 19 }));

        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {

        Stack<Integer> org = new Stack<>();

        for (Integer i : A) {
            org.push(i);
        }

        Stack<Integer> sorted = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        sorted.push(org.pop());
        while (!org.isEmpty()) {
            int val = org.pop();
            int sortedTop = sorted.peek();
            if (sortedTop > val) {
                while (!temp.isEmpty() && temp.peek() > val) {
                    sorted.push(temp.pop());
                }
                sorted.push(val);
            } else {
                while (!sorted.isEmpty() && sorted.peek() < val) {
                    temp.push(sorted.pop());
                }
                sorted.push(val);
            }
        }

        while (!temp.isEmpty()) {
            sorted.push(temp.pop());
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!sorted.isEmpty()) {
            ans.add(sorted.pop());
        }

        return ans;
    }

}
