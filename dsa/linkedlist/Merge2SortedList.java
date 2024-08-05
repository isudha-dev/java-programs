package dsa.linkedlist;

public class Merge2SortedList {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode p1 = A;
        ListNode p2 = B;
        if (p1 == null)
            return p2;
        if (p2 == null)
            return p1;

        ListNode head, tail;
        if (p1.val < p2.val) {
            head = p1;
            tail = p1;
            p1 = p1.next;
        } else {
            head = p2;
            tail = p2;
            p2 = p2.next;
        }

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                tail = tail.next;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;
            }
        }
        while (p1 != null){
            tail.next = p1;
            tail = tail.next;
            p1 = p1.next;
        }

        while (p2 != null){
            tail.next = p2;
            tail = tail.next;
            p2 = p2.next;
        }

        return head;
    }

}
