package dsa.subsequence_subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllSubset {

    public static void main(String[] args) {
        System.out.println(subsets1(new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 5, 7, 9, 12 }))));
    }

    static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        // Since values are required in lex order lets sort given collection
//        Collections.sort(A);
        // call recursive method
        computeSubSet(0, A, new ArrayList<>(), resList);
        return resList;
    }

    static void computeSubSet(int index, ArrayList<Integer> A, ArrayList<Integer> tempList,
            ArrayList<ArrayList<Integer>> resList) {
        // add currentlist to result as its valid subset
        resList.add(new ArrayList<Integer>(tempList));

        // for loop to iterate from start to end of inputlist
        for (int i = index; i < A.size(); i++) {
            // DO operation
            tempList.add(A.get(i));
            // Recursive call for next element
            computeSubSet(index + 1, A, tempList, resList);
            // UNDO operation
            tempList.remove(tempList.size() - 1);
        }
    }

    static ArrayList<ArrayList<Integer>> subsets1(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        Collections.sort(A);
        int n = A.size();

        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    tempList.add(A.get(j));
                }
            }
            resList.add(new ArrayList<Integer>(tempList));
        }

        return resList;
    }
}
