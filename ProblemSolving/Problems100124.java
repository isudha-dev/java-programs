package ProblemSolving;

import java.util.*;
import java.util.stream.Collectors;

public class Problems100124 {

    public static void main(String[] args) {
        System.out.println(findOccurences(new ArrayList<>(Arrays.asList(56, 35, 25, 32, 41, 50, 7, 52, 34, 41, 72, 12, 93, 50, 19, 94, 13, 19))));

    }

    public static ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: A){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        List<Integer> sortedList = map.keySet().stream().collect(Collectors.toList());
        Collections.sort(sortedList);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: sortedList){
            ans.add(map.get(i));
        }

        return ans;

    }
}
