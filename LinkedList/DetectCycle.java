package linkedlist;

public class DetectCycle {

    public ListNode detectCycle(ListNode A) {
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast) {
            return null;
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
        }

        return slow.next;
    }

}
