package linkedlist;

import java.util.ArrayList;

// https://www.scaler.com/academy/mentee-dashboard/class/25579/assignment/problems/4371?navref=cl_tt_nv
public class SinglyLinkedList {

    // 0 x -1: Add a node of value x before the first element of the linked list.
    // After the insertion, the new node will be the first node of the linked list.

    // 1 x -1: Append a node of value x to the last element of the linked list.

    // 2 x index: Add a node of value x before the indexth node in the linked list.
    // If the index equals the length of the linked list, the node will be appended
    // to the end of the linked list. If the index is greater than the length, the
    // node will not be inserted.

    // 3 index -1: Delete the indexth node in the linked list, if the index is
    // valid.

    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {

        public ListNode head;
        public int length;

        public ListNode solve(ArrayList<ArrayList<Integer>> A) {

            for (ArrayList<Integer> list : A) {
                if (list.get(0) == 0) {
                    insertAtStart(list.get(1));
                } else if (list.get(0) == 1) {
                    insertAtEnd(list.get(1));
                } else if (list.get(0) == 2) {
                    insertAtIndex(list.get(2), list.get(1));
                } else if (list.get(0) == 3) {
                    deleteAtIndex(list.get(1));
                }
            }

            return head;
        }

        void insertAtStart(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            length++;
        }

        void insertAtEnd(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                ListNode tempNode = head;
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                }
                tempNode.next = newNode;
            }
            length++;
        }

        void insertAtIndex(int index, int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                int counter = 0;
                ListNode tempNode = head;
                while (counter < index - 1) {
                    tempNode = tempNode.next;
                }
                newNode.next = tempNode.next;
                tempNode.next = newNode;
            }
            length++;
        }

        void deleteAtIndex(int index) {
            if (index < 0 || index > length - 1) {
                return;
            } else if (index == 0) {
                head = head.next;
            } else {
                int counter = 0;
                ListNode tempNode = head;
                while (counter < index - 1) {
                    tempNode = tempNode.next;
                    counter++;
                }
                tempNode.next = tempNode.next.next;
            }
            length--;
        }
    }
}
