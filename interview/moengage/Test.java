package interview.moengage;

import java.util.*;

public class Test {
    /*
        Find the length of the longest substring without repeating characters in a string.

        E.g.
        bbdefdefk -> 4 -> defk | bdef\
        012345678

     */

    public static void main(String[] args) {
//        longestSs("abc");
        longestConc(new int[]{10, 8, 4, 3, 9, 0, 1, 11, 2, 12, 13});
    }

    public static void longestSs(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        int currLen = 0;
        int maxLen = Integer.MIN_VALUE;
        int p1 = 0;
        int p2 = 0;

        while (p2 < s.length()){
            Character c = s.charAt(p2);
            if(!map.containsKey(c)){
                map.put(c, p2);
                p2++;
            } else {
                p2++;
                p1 = map.get(c)+1;
                map.put(c, p2);
            }
            currLen = p2 - p1;
            maxLen = Math.max(maxLen, currLen);
        }
        System.out.println(maxLen);
    }

    /*
        Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
        [10,5, 8, 4, 3, 9, 1, 11, 2]
        ans  = 5 (1,2,3,4,5) 5
        i+1 =
        1 -> 1,2,3,4,5
        8 -> 8,9,10,11

     */

    public static void longestConc(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(i -> set.add(i));

        int maxCount = Integer.MIN_VALUE;
        int currCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i]-1)){
                continue;
            } else {
                currCount = 1;
                int k = arr[i]+1;
                while (set.contains(k)){
                    currCount++;
                    k++;
                }
                maxCount = Math.max(maxCount, currCount);
            }
        }
        System.out.println(maxCount);

    }






}
