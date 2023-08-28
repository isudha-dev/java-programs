package dsa.contest.july08.tct1ReAttempt;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayIntersection {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        for(int i: A){
            setA.add(i);
        }

        for(int i: B){
            setB.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i: setA){
            if(setB.contains(i)){
                ans.add(i);
            }
        }

        return null;
    }

}
