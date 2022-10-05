package linkedlist;

import java.util.Stack;

public class ReorderLL {

    public ListNode reorderListUsingStack(ListNode A) {

        // using stack
        Stack<ListNode> stk = new Stack<>();
        ListNode temp = A;
        while (temp != null) {
            stk.push(temp);
            temp = temp.next;
        }
        ListNode p1 = A;
        ListNode p2 = stk.pop();

        while (p1.next != null) {
            ListNode tempNode = p1.next;
            if (p2 == tempNode) {
                break;
            }
            p1.next = p2;
            p2.next = tempNode;
            p1 = tempNode;
            p2 = stk.pop();
            p2.next = null;
        }

        return A;

        // TC: O(n) SC: O(n)

    }

    public ListNode reorderListWithoutExtraSpace(ListNode A) {

        // reversing mid of list O(N) / O(1)
        ListNode mid;
        ListNode slow = A, fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;
        ListNode p1 = A;
        ListNode p2 = reverseLL(mid);

        while (p1 != null && p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;

        }

        return A;

    }

    public ListNode reverseLL(ListNode A) {
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

    public static void main(String[] args) {
        int num = 1;
        ListNode head = new ListNode(num);
        int len = 6;

        LinkedListOps llo = new LinkedListOps();
        while (len > 1) {
            llo.insertAtLast(head, ++num);
            len--;
        }

        ReorderLL rll = new ReorderLL();
        System.out.println(rll.reorderListWithoutExtraSpace(head));

    }

}
