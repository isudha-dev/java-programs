package dsa.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/maximal-network-rank/
public class MaximalNetworkRank {

    public static int maximalNetworkRank(int n, int[][] roads) {
        // create count map for each city
        int[] countConnectedCity = new int[n];
        for(int[] road: roads){
            countConnectedCity[road[0]] = ++countConnectedCity[road[0]];
            countConnectedCity[road[1]] = ++countConnectedCity[road[1]];
        }

        // create set for each city to indicate unique cities it's connected to
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] road: roads){
            Set<Integer> set0 = map.get(road[0]);
            if(set0 == null)
                set0 = new HashSet<>();
            set0.add(road[1]);
            map.put(road[0], set0);

            Set<Integer> set1 = map.get(road[1]);
            if(set1 == null)
                set1 = new HashSet<>();
            set1.add(road[0]);
            map.put(road[1], set1);
        }

        // dp[i] -> total number for cities connected to i (size n)

        // pick any 2 max numbers from dp[] -> ans = dp[1]+dp[2]
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        Set<Integer> city1 = new HashSet<>();
        Set<Integer> city2 = new HashSet<>();
        for(int i = 0; i< n; i++){
            if(countConnectedCity[i] > max1) {
                city1.clear();
                max1 = countConnectedCity[i];
                city1.add(i);
            } else if (countConnectedCity[i] == max1){
                city1.add(i);
            }
        }
        for(int i = 0; i< n; i++){
            if(countConnectedCity[i] > max2 && countConnectedCity[i] < max1){
                city2.clear();
                max2 = countConnectedCity[i];
                city2.add(i);
            } else if (countConnectedCity[i] == max2 && countConnectedCity[i] < max1){
                city2.add(i);
            }
        }

        int ans = max1+max2;

        // check if those cities from city1 and city2 set are connected? if yes, reduce 1 from ans
//        if(city1.size()>1){
//            ans = max1+max1;
//            for(int city: city1){
//
//            }
//        }

        if(map.get(city1).contains(city2) || map.get(city2).contains(city1)){
            ans--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] roads = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};
        maximalNetworkRank(5, roads);
    }
}
