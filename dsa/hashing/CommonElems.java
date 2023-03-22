package dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElems {

    // https://www.scaler.com/academy/mentee-dashboard/class/25565/assignment/problems/10203?navref=cl_tt_nv
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 2, 1, 3 }));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(new Integer[] { 2, 3, 1, 2, 2 }));

        System.out.println(solve(A, B));

    }

    static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        HashMap<Integer, Integer> mapA = new HashMap<>();

        for (Integer i : A) {
            mapA.put(i, mapA.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer i : B) {
            if (mapA.containsKey(i) && mapA.get(i) != 0) {
                ans.add(i);
                mapA.put(i, mapA.get(i) - 1);
            }
        }

        return ans;
    }

}
