package linkedlist;

public class ReverseLLFromBtoC {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null || A.next == null)
            return A;
        ListNode prev = null;
        ListNode curr = A;

        for (int i = 1; curr != null && i < B; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode start = curr;
        ListNode end = null;

        for (int i = 1; curr != null && i <= C - B + 1; i++) {
            ListNode next = curr.next;
            curr.next = end;
            end = curr;
            curr = next;
        }

        if (start != null) {
            start.next = curr;
            if (prev != null)
                prev.next = end;
            else
                A = end;
        }
        return A;
    }
}
