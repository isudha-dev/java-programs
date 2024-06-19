package ProblemSolving;

import java.util.*;

public class Problems_18_June_24 {
    public static void main(String[] args) {
        System.out.println(solve("abbaee"));
    }

    public static int solve(String A) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character c: A.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int odd = 0;
        for(int i: map.values()){
            if(i%2 != 0){
                odd++;
            }
        }

        return odd > 1 ? 0 : 1;

    }

}
