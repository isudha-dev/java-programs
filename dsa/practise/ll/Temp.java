package dsa.practise.ll;

import java.util.HashSet;

public class Temp {

    static ListNode head = null;
    static ListNode tail = null;
    public static void insert_node(int position, int value) {
        ListNode newNode = new ListNode(value);
        if(position == 1 && head == null) {
            head = newNode;
            tail = newNode;
        } else if (position == 1 && head != null) {
            newNode.next = head;
            head = newNode;
        } else {
            int cnt = 1;
            ListNode temp = head;
            while (cnt < position - 1 && temp != null) {
                temp = temp.next;
                cnt++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            if(newNode.next == null){
                tail = newNode;
            }
        }
    }

    public static void delete_node(int position) {
        int cnt = 1;
        ListNode temp = head;
        while (cnt < position - 1 && temp != null) {
            temp = temp.next;
            cnt++;
        }
        temp.next = temp.next.next;
    }

    public static void print_ll() {
        ListNode temp = head;
        while (temp!= null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();

    }

    public int middleElem(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr.val;
    }

    public ListNode deleteMiddleNode(ListNode A) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prev = null;
        while(fastPtr != null && fastPtr.next!=null){
            prev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        prev.next = prev.next.next;
        return head;

    }

    public static ListNode kReverseList(ListNode head, int B) {
        if(head == null || head.next == null){
            return head;
        }
        if(B == 1){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        int cnt = 1;
        while (curr!=null && cnt<=B){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        if(next!=null){
            head.next = kReverseList(next, B);
        }

        return prev;
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if(A==null ||A.next==null)
            return null;

        ListNode temp = A;
        while (B > 0){
            if(temp == null){
                return A.next;
            }
            temp = temp.next;
            B--;
        }

        if(B == 0 && temp == null){
            return A.next;
        }

        ListNode newHead = A;
        while (temp!=null && temp.next!=null) {
            newHead = newHead.next;
            temp = temp.next;
        }

        newHead.next = newHead.next.next;
        return A;
    }

    public static ListNode deleteDuplicates(ListNode A) {

        ListNode temp = A;

        while (temp.next!=null){
            int currVal = temp.val;
            int nextVal = temp.next.val;
            if(currVal == nextVal){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return A;
    }

    public ListNode detectCycle(ListNode a) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode temp = a;
        while (temp!=null){
            if(set.contains(temp)){
                return temp;
            } else {
                set.add(temp);
            }
            temp = temp.next;
        }
        return null;
    }

    public ListNode removeLoopFromLl(ListNode A) {
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast) {
            return A;
        } else {
            if (slow == A) {
                while (slow.next != A)
                    slow = slow.next;
            } else {
                fast = A;
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            slow.next = null;
        }

        return A;
    }

    public static ListNode reorderList(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        ListNode prev = null;
        while (fast.next!=null && fast.next.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        //reverse list
        ListNode A2 = reverseList(slow);
        ListNode A1 = A;
        ListNode temp = null;
        while (A1 != null && A2 != null){
            temp = A1.next;
            A1.next = A2;
            A1.next.next = temp;
            A2 = A2.next;
            A1 = temp;
        }

        return A;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head, tail;
        ListNode p1 = A;
        ListNode p2 = B;
        if(A.val< B.val){
            head = A;
            tail = A;
            p1 = p1.next;
        } else {
            head = B;
            tail = B;
            p2 = p2.next;
        }

        while (p1 != null && p2 != null){
            if(p1.val < p2.val){
                tail.next = p1;
                tail = tail.next;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;
            }
        }

        if(p1 != null){
            tail.next = p1;
        }
        if(p2 != null){
            tail.next = p2;
        }

        return head;
    }

    public ListNode sortList(ListNode A) {
        if(A == null || A.next == null){
            return A;
        }
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = A;
        ListNode head2 = slow.next;
        slow.next = null; //cutting head1

        head1 = sortList(head1);
        head2 = sortList(head2);
        return mergeTwoLists(head1,head2);
    }

    public int lPalin(ListNode A) {
        if(A == null || A.next == null){
            return 1;
        }
        //finding mid
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = A;
        ListNode head2 = slow.next;
        slow.next = null; //shortening A

        //reverse list head2
        ListNode prev = null;
        ListNode curr = head2;
        ListNode next = null;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head2 = prev;

        // compare two list and return if not equal values
        while (head1 !=null && head2!=null){
            if(head1.val != head2.val){
                return 0;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return 1;
    }

    public int longestPalinList(ListNode A) {
        // from each node, reverse the left side nodes and then compare nodes on left and right side of selected node
        int ans = 0;
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            ans = Math.max(ans, findLen(prev, next)+1);
            ans = Math.max(ans, findLen(curr, next));
            prev = curr;
            curr = next;
        }

        return ans;
    }

    public int findLen(ListNode p1, ListNode p2){
        if(p1==null || p2==null){
            return 0;
        }
        int len = 0;
        while (p1!=null && p2!=null){
            if(p1.val != p2.val){
                return len;
            } else {
                len = len+2;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return len;
    }

    ListNode2 flatten(ListNode2 root) {

        ListNode2 prev = null;
        ListNode2 curr = root;
        ListNode2 next = null;

        while (curr!=null){
            if(curr.right.val < curr.down.val){
                prev = curr;

            }

        }


        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;
        temp.next = new ListNode(7);
        temp = temp.next;
        temp.next = new ListNode(6);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(9);
        temp = temp.next;
        temp.next = new ListNode(2);
        temp = temp.next;


        reorderList(head);

    }

}
