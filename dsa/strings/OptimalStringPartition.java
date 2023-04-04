package dsa.strings;

import java.util.HashSet;
import dsa.backtracking.Hashset;

//https://leetcode.com/problems/optimal-partition-of-string/
public class OptimalStringPartition {

    public static void main(String[] args) {
        System.out.println("Total partition: " + partitionString("abkcabkc"));
    }

    public static int partitionString(String s) {
        int count = 0;

        HashSet<Character> tempSet = new HashSet<>();

        for(int i = 0 ; i < s.length(); i++){
            int prevLen = tempSet.size();
            tempSet.add(s.charAt(i));
            if(prevLen == tempSet.size()){
                count++;
                tempSet = new HashSet<>();
                tempSet.add(s.charAt(i));
            }
        }
        if(tempSet.size()!=0)
            count++;

        return count;

    }
}
