package dsa.contest.july08.tct2reattempt;

public class OddEvenLL {

    public static ListNode solve(ListNode A) {

        ListNode head = A;
        ListNode head2 = A.next;

        ListNode curr = head;
        ListNode next = null;

        while(curr != null && curr.next != null && curr.next.next != null){
            next = curr.next;
            curr.next = next.next;
            next.next = curr.next.next;
            curr = curr.next;
        }
        curr.next = head2;

        return head;


    }

    public static void main(String[] args) {
        ListNode A = new ListNode(6);
        ListNode head = A;
        A.next = new ListNode(7);
        A = A.next;
        A.next = new ListNode(10);
        A = A.next;
        A.next = new ListNode(3);
        A = A.next;
        A.next = new ListNode(10);
        A = A.next;
        A.next = new ListNode(10);
        A = A.next;
        A.next = new ListNode(3);
        A = A.next;
        A.next = new ListNode(10);

        solve(head);
    }
}

// Definition for singly-linked list.
class ListNode {
  public int val;
  public ListNode next;
  ListNode(int x) { val = x; next = null; }
}
