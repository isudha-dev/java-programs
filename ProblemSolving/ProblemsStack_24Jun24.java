package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class ProblemsStack_24Jun24 {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(66,96,43,28,14,1,41,76,70,81,22,11,42,78,4,88,70,43,90,6,12))));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        /*
            5, 17, 100, 11

            5 11
            100 17

         */
        Stack<Integer> main = new Stack<>();
        Stack<Integer> helper = new Stack<>();

        for(int i = 0; i<A.size(); i++){
            while(!main.isEmpty() && main.peek() > A.get(i)){
                helper.push(main.pop());
            }
            main.push(A.get(i));
            while (!helper.isEmpty()){
                main.push(helper.pop());
            }
        }




        return (ArrayList<Integer>) main.stream().collect(Collectors.toList());
    }
}
