package dsa.linkedlist;

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

    public ListNode reverseBetween1(ListNode A, int B, int C) {
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        int count = B - 1;
        while (count > 0) {
            prev = curr;
            curr = curr.next;
            count--;
        }
        ListNode start = prev;
        ListNode end = curr;

        count = 0;
        while (count < (C - B + 1)) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (end != null) {
            end.next = curr;
            if (start != null)
                start.next = prev;
            else
                A = prev;
        }

        return A;
    }

    public static void main(String[] args) {
        int num = 1;
        ListNode head = new ListNode(num);
        int len = 9;

        LinkedListOps llo = new LinkedListOps();
        while (len > 1) {
            llo.insertAtLast(head, ++num);
            len--;
        }

        ReverseLLFromBtoC bc = new ReverseLLFromBtoC();
        System.out.println(bc.reverseBetween1(head, 4, 7));

    }

}
