package dsa.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PassingGame {

    public static void main(String[] args) {
        System.out.println(solve(10, 23,
                new ArrayList<Integer>(Arrays.asList(new Integer[] { 86, 63, 60, 0, 47, 0, 99, 9, 0, 0 }))));
    }

    public static int solve(int A, int B, ArrayList<Integer> C) {

        Stack<Integer> game = new Stack<>();
        game.push(B);
        for (Integer i : C) {
            if (i != 0) {
                game.push(i);
            } else {
                game.pop();
            }
        }

        return game.pop();
    }

}
