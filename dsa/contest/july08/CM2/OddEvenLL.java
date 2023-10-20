package dsa.contest.july08.CM2;

public class OddEvenLL {

    public static ListNode solve(ListNode A) {

        ListNode evenHead = A.next;
        ListNode odd = A;
        ListNode even = A.next;

        while(odd != null && odd.next != null && even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        while (even != null && even.next != null){
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        ListNode temp = head;
        temp.next = new ListNode(7);
        temp = temp.next;
        temp.next = new ListNode(10);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(10);
        temp = temp.next;
        temp.next = new ListNode(10);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(10);

        solve(head);

    }

}


class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
 }
