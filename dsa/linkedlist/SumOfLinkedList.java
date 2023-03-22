package dsa.linkedlist;

public class SumOfLinkedList {

    public static void main(String[] args) {

    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy, ans = new ListNode(0);
        dummy = ans;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            ans.next = new ListNode(carry % 10);
            carry /= 10;
            ans = ans.next;

        }

        return dummy.next;

    }

}
