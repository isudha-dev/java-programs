package interview.fiddler_ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Round1 {
    /*

    Given an array arr[] of size n, the task is to find all subarrays in the array which has sum 0.
    Input: arr = [6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7, 9]
    output: List<List<Integer>>

        0 1 2 3 4 5 6 7  8  9 10 11
        6 9 8 5 9 7 9 13 19 7 0  9
      0 6 9 8 5 9 7 9 13 19 7 0

[2, 4]
[2, 6]
[5, 6]
[6, 9]
[0, 10]


9 -> 1, 4
 4, 6
i = 6
2, 6
5, 6

2, 9
5, 9


     */

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<List<Integer>> ans = zeroSum1(arr);
        ans.forEach(System.out::println);

    }

    public static List<List<Integer>> zeroSum(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if(map.containsKey(prefixSum)){
                ans.add(List.of(map.get(prefixSum)+1, i));
            }
            map.put(prefixSum, i);
        }

        return ans;
    }

    public static List<List<Integer>> zeroSum1(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, List.of(-1));

        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if(map.containsKey(prefixSum)){

                List<Integer> indices = map.get(prefixSum);
                for (int j = 0; j < indices.size(); j++) {
                    ans.add(List.of(indices.get(j) + 1, i));
                }
                List<Integer> indices1 = new ArrayList<>();
                map.get(prefixSum).forEach(val -> indices1.add(val));
                indices1.add(i);
                map.put(prefixSum,indices1 );
            } else {
                map.put(prefixSum, List.of(i));
            }


        }

        return ans;
    }




}
