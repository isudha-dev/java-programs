package dsa.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/description/
public class BoatsToSavePeopleLC {

    public static void main(String[] args) {

    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int countBoats = 0;

        while(l <= r) {
            if(people[l]+people[r] <= limit){
                countBoats++;
                l++;
                r--;
            } else {
                countBoats++;
                r--;
            }
        }

        return countBoats;

    }
}
