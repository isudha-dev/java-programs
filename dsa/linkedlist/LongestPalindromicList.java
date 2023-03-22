package dsa.linkedlist;

public class LongestPalindromicList {

    public int solve(ListNode A) {
        ListNode curr = A, prev = null, next = null;
        int ans = 0;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            // odd len
            ans = Math.max(ans, findLen(prev, next) + 1);
            // even len
            ans = Math.max(ans, findLen(curr, next));
            prev = curr;
            curr = next;
        }

        return ans;
    }

    public int findLen(ListNode p1, ListNode p2) {
        int len = 0;

        while (p1 != null && p2 != null) {
            if (p1.val == p2.val)
                len += 2;
            else
                break;
            p1 = p1.next;
            p2 = p2.next;
        }
        return len;
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

        LongestPalindromicList bc = new LongestPalindromicList();
        System.out.println(bc.solve(head));

    }

}
