package dsa.linkedlist;

public class PartitionLL {

    public ListNode partition(ListNode A, int B) {

        ListNode left = A, right = null;
        ListNode ptr = A, currL = null, currR = null;
        while (ptr != null) {
            if (ptr.val < B) {
                if (currL == null) {
                    currL = ptr;
                    left = currL;
                } else {
                    currL.next = ptr;
                    currL = currL.next;
                }
            } else {
                if (currR == null) {
                    currR = ptr;
                    right = currR;
                } else {
                    currR.next = ptr;
                    currR = currR.next;
                }
            }
            ptr = ptr.next;
        }
        if (currL == null)
            return right;
        else if (currR == null)
            return left;
        else {
            currL.next = right;
            currR.next = null;
            return left;
        }
    }

    public static void main(String[] args) {
        int[] num = { 384, 183, 463, 31 };
        int len = 0;
        ListNode head = new ListNode(num[len]);
        len++;

        LinkedListOps llo = new LinkedListOps();
        while (len < num.length) {
            llo.insertAtLast(head, num[len]);
            len++;
        }

        PartitionLL bc = new PartitionLL();
        System.out.println(bc.partition(head, 77));

    }

}
