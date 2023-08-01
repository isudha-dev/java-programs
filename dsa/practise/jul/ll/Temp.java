package dsa.practise.jul.ll;

import java.util.HashSet;

public class Temp {

    static ListNode head = null;
    static ListNode tail = null;
    public static void insert_node(int position, int value) {
        ListNode newNode = new ListNode(value);
        if(position == 1 && head == null) {
            head = newNode;
            tail = newNode;
        } else if (position == 1 && head != null) {
            newNode.next = head;
            head = newNode;
        } else {
            int cnt = 1;
            ListNode temp = head;
            while (cnt < position - 1 && temp != null) {
                temp = temp.next;
                cnt++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            if(newNode.next == null){
                tail = newNode;
            }
        }
    }

    public static void delete_node(int position) {
        int cnt = 1;
        ListNode temp = head;
        while (cnt < position - 1 && temp != null) {
            temp = temp.next;
            cnt++;
        }
        temp.next = temp.next.next;
    }

    public static void print_ll() {
        ListNode temp = head;
        while (temp!= null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();

    }

    public int middleElem(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr.val;
    }

    public ListNode deleteMiddleNode(ListNode A) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prev = null;
        while(fastPtr != null && fastPtr.next!=null){
            prev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        prev.next = prev.next.next;
        return head;

    }

    public static ListNode kReverseList(ListNode head, int B) {
        if(head == null || head.next == null){
            return head;
        }
        if(B == 1){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        int cnt = 1;
        while (curr!=null && cnt<=B){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        if(next!=null){
            head.next = kReverseList(next, B);
        }

        return prev;
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if(A==null ||A.next==null)
            return null;

        ListNode temp = A;
        while (B > 0){
            if(temp == null){
                return A.next;
            }
            temp = temp.next;
            B--;
        }

        if(B == 0 && temp == null){
            return A.next;
        }

        ListNode newHead = A;
        while (temp!=null && temp.next!=null) {
            newHead = newHead.next;
            temp = temp.next;
        }

        newHead.next = newHead.next.next;
        return A;
    }

    public static ListNode deleteDuplicates(ListNode A) {

        ListNode temp = A;

        while (temp.next!=null){
            int currVal = temp.val;
            int nextVal = temp.next.val;
            if(currVal == nextVal){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        ListNode temp = head;
        temp.next = new ListNode(10);
        temp = temp.next;
        temp.next = new ListNode(6);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(8);
        temp = temp.next;

        deleteDuplicates(head);

    }

}
