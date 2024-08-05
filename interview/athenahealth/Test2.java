package interview.athenahealth;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    /*
        2 4
        6 3
     */
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(List.of(2, 4));
        arr.add(List.of(6, 3));

        int max = Integer.MIN_VALUE;
        for(List<Integer> row : arr){
            for(int i: row){
                max = Math.max(max, i);
            }
        }

        System.out.println("Max: " + max);
    }
}
