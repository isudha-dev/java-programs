package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;

import linkedlist.SinglyLinkedList.Solution;

public class SinglyLinkedListRunner {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Solution newSol = sll.new Solution();

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 13, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 0, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 1, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 15, 0 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 0, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 12, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 0, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 19, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 13, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 0, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 0, 12, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 13, -1 })));
        A.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 2, -1 })));

        linkedlist.SinglyLinkedList.ListNode ln = newSol.solve(A);
        System.out.println("Wait");

    }

}
