package linkedlist;

public class RemoveLoop {

    public ListNode solve(ListNode A) {

        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast) {
            return A;
        } else {
            if (slow == A) {
                while (slow.next != A)
                    slow = slow.next;
            } else {
                fast = A;
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            slow.next = null;
        }

        return A;
    }

}
