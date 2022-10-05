package linkedlist;

public class FlattenLL {
    class ListNode {
        int val;
        ListNode right, down;

        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }

    ListNode flatten(ListNode root) {
        if (root == null || root.right == null)
            return root;

        ListNode mid = root, fast = root;
        while (fast.right != null && fast.right.right != null) {
            mid = mid.right;
            fast = fast.right.right;
        }
        ListNode h1 = root;
        ListNode h2 = mid.right;
        mid.right = null;
        ListNode newH1 = flatten(h1);
        ListNode newH2 = flatten(h2);

        ListNode mergedList = mergeTwoLists(newH1, newH2);

        return mergedList;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode p1 = A;
        ListNode p2 = B;
        if (p1 == null)
            return p2;
        if (p2 == null)
            return p1;

        ListNode head, tail;
        if (p1.val < p2.val) {
            head = p1;
            tail = p1;
            p1 = p1.down;
        } else {
            head = p2;
            tail = p2;
            p2 = p2.down;
        }

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.down = p1;
                tail = p1;
                p1 = p1.down;
            } else {
                tail.down = p2;
                tail = p2;
                p2 = p2.down;
            }
        }
        if (p1 == null)
            tail.down = p2;
        if (p2 == null)
            tail.down = p1;

        return head;
    }

    ListNode flattenFirst(ListNode root) {
        ListNode temp = root;
        ListNode p1 = root.down;
        ListNode p2 = root.right;

        ListNode next = p2.right;

        while (next != null) {
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    temp.down = p1;
                    p1 = p1.down;
                } else {
                    temp.down = p2;
                    p2 = p2.down;
                }
                temp = temp.down;
            }
            if (p1 == null) {
                p1 = next;
                next = p1.right;
            }
            if (p2 == null) {
                p2 = next;
                next = p2.right;
            }
        }

        return root;
    }

}
