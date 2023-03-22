package dsa.linkedlist;

public class SortLLUsingMergeSort {

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null)
            return A;
        ListNode slow = A, fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h1 = A;
        ListNode h2 = slow.next;
        slow.next = null;
        ListNode newH1 = sortList(h1);
        ListNode newH2 = sortList(h2);

        Merge2SortedList merge = new Merge2SortedList();
        ListNode mergedList = merge.mergeTwoLists(newH1, newH2);
        return mergedList;
    }

    public static void main(String[] args) {
        int num = 1;
        ListNode head = new ListNode(num);
        int len = 4;

        LinkedListOps llo = new LinkedListOps();
        while (len > 1) {
            llo.insertAtLast(head, ++num);
            len--;
        }

        SortLLUsingMergeSort bc = new SortLLUsingMergeSort();
        System.out.println(bc.sortList(head));

    }

}
