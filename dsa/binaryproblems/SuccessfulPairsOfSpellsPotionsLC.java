package dsa.binaryproblems;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsPotionsLC {

    public static void main(String[] args) {
        successfulPairs(new int[] {3,1,2}, new int[] {8,5,8}, 16);

    }


    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];

        int n = potions.length;


        for(int i = 0; i < spells.length; i++){
            int start = 0;
            int end = n-1;
            int mid;
            while(start <= end){
                mid = (start+end)/2;
                long prod = (long) spells[i] * potions[mid];
                if(prod >= success){
                    end = mid - 1;
                } else {
                    start = mid+1;
                }
            }
            pairs[i] = n - start;
        }

        return pairs;
    }
}
