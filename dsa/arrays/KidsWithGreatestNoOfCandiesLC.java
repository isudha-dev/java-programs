package dsa.arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class KidsWithGreatestNoOfCandiesLC {

    public static void main(String[] args) {
        kidsWithCandies(new int[] {2,3,5,1,3},3);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i: candies){
            max = Math.max(max, i);
        }

        for(int i = 0; i < candies.length; i++){
            int totalCandies = candies[i]+extraCandies;
            if(totalCandies >= max){
                ans.add(i, true);
            } else {
                ans.add(i, false);
            }
        }
        return ans;
    }
}
