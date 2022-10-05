package linkedlist;

public class ReverseLL {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode A) {
        if (A == null) {
            return null;
        }
        if (A.next == null) {
            return A;
        }
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}