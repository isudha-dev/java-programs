package linkedlist;

public class DeleteDuplicateFromSortedList {

    public ListNode deleteDuplicates(ListNode A) {
        if (A == null) {
            return A;
        }
        ListNode temp = A;
        while (temp.next != null) {
            int currVal = temp.val;
            int nextVal = temp.next.val;
            if (currVal == nextVal) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return A;
    }

}
