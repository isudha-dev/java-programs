package dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinGroupsForValidAssignment {

    public static void main(String[] args) {
        //        System.out.println(goodPair(new int[] {1,2,3,4}, 7));
        //        System.out.println(pickFromBothSides(new int[] {2, 3, -1, 4, 2, 1}, 4));
        //        System.out.println(countingSubarray(242, new int[] {15,8,16}));
        System.out.println(minGroupsForValidAssignment(new int[] {1,1,3,3,1,1,2,2,3,1,3,2}));
        // 3,2,3,2,3 -> 2
        // 2,3,2,2,2 -> 3
        // 1,1,2,1,1,1,3,1,2,3 -> 4
        // 1,1,1,1,2,2,2,1,2,1,1 -> 3
        // 10,10,10,3,1,1 -> 4
        // 1,1,3,3,1,1,2,2,3,1,3,2 -> 5 [1->5, 2-> 3, 3-> 4] 2->1(3), 3->1(4), 1-> 2(3,2)
        // failing because groups created 2->3 3->4 1->4,1. Now group of size 1 and size 3 aren't valid.
        // valid groups 2->3 3->2,2 1->3,2 or 2->3 3->4 1->3,2
    }

    static int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minFreq = Integer.MAX_VALUE;
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            minFreq = Math.min(minFreq, entry.getValue());
        }

        int groups = 0;
        int maxFreq = minFreq+1;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            if(freq == minFreq || freq == maxFreq){
                groups++;
                continue;
            }

            // consider maxFreq
            int currGroups = freq/maxFreq;
            int remainder = freq%maxFreq;
            if(remainder == 0){
                groups += currGroups;
                continue;
            } else if(!(minFreq - remainder > 1)){
                currGroups++;
                groups += currGroups;
                continue;
            } // else we can't create groups with maxFreq so let's consider minFreq

            currGroups = freq/minFreq;
            remainder = freq%minFreq;
            if(remainder == 0){
                groups += currGroups;
            } else {
                currGroups++;
                groups += currGroups;
            }
        }

        return groups;
    }

}
