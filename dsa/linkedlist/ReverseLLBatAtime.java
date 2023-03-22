package dsa.linkedlist;

public class ReverseLLBatAtime {
    public ListNode reverseList(ListNode A, int B) {
        return reverseBAtaTime(A, B);
    }

    public ListNode reverseBAtaTime(ListNode A, int B) {
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < B) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null)
            A.next = reverseBAtaTime(next, B);

        return prev;
    }
}
