package dsa.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

import dsa.linkedlist.LinkedListOps;
import dsa.linkedlist.ListNode;

public class MergeKSortedLists {

    public static void main(String[] args) {
        int[] num = { 8, 20, 38, 44, 55, 65, 66, 79, 87 };
        int len = 0;
        ListNode head1 = new ListNode(num[len]);
        len++;

        LinkedListOps llo = new LinkedListOps();
        while (len < num.length) {
            llo.insertAtLast(head1, num[len]);
            len++;
        }

        ArrayList<ListNode> a = new ArrayList<>();
        a.add(head1);

        num = new int[] { 68, 72 };
        len = 0;
        head1 = new ListNode(num[len]);
        len++;
        while (len < num.length) {
            llo.insertAtLast(head1, num[len]);
            len++;
        }
        a.add(head1);

        num = new int[] { 5, 55, 61, 73, 89 };
        len = 0;
        head1 = new ListNode(num[len]);
        len++;
        while (len < num.length) {
            llo.insertAtLast(head1, num[len]);
            len++;
        }
        a.add(head1);

        num = new int[] { 30, 73 };
        len = 0;
        head1 = new ListNode(num[len]);
        len++;
        while (len < num.length) {
            llo.insertAtLast(head1, num[len]);
            len++;
        }
        a.add(head1);

        num = new int[] { 28, 73, 84, 96 };
        len = 0;
        head1 = new ListNode(num[len]);
        len++;
        while (len < num.length) {
            llo.insertAtLast(head1, num[len]);
            len++;
        }
        a.add(head1);

        num = new int[] { 54, 82, 83 };
        len = 0;
        head1 = new ListNode(num[len]);
        len++;
        while (len < num.length) {
            llo.insertAtLast(head1, num[len]);
            len++;
        }
        a.add(head1);

        num = new int[] { 15, 33, 38, 94, 100 };
        len = 0;
        head1 = new ListNode(num[len]);
        len++;
        while (len < num.length) {
            llo.insertAtLast(head1, num[len]);
            len++;
        }
        a.add(head1);

        num = new int[] { 4 };
        len = 0;
        head1 = new ListNode(num[len]);
        len++;
        while (len < num.length) {
            llo.insertAtLast(head1, num[len]);
            len++;
        }
        a.add(head1);

        num = new int[] { 22, 32, 42, 64, 86 };
        len = 0;
        head1 = new ListNode(num[len]);
        len++;
        while (len < num.length) {
            llo.insertAtLast(head1, num[len]);
            len++;
        }
        a.add(head1);

        num = new int[] { 11, 78 };
        len = 0;
        head1 = new ListNode(num[len]);
        len++;
        while (len < num.length) {
            llo.insertAtLast(head1, num[len]);
            len++;
        }
        a.add(head1);

        MergeKSortedLists mk = new MergeKSortedLists();
        mk.mergeKLists(a);

    }

    // 10 9 8 20 38 44 55 65 66 79 87 2 68 72 5 5 55 61 73 89 2 30 73 4 28 73 84 96
    // 3 54 82 83 5 15 33 38 94 100 1 4 5 22 32 42 64 86 2 11 78

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        int k = a.size();
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> (x.val - y.val));

        for (int i = 0; i < k; i++) {
            pq.add(a.get(i));
        }

        ListNode min = pq.poll();
        ListNode outputHead = min;
        ListNode outputTail = min;
        min = min.next;
        if (min != null)
            pq.add(min);
        while (!pq.isEmpty()) {
            min = pq.poll();
            outputTail.next = min;
            outputTail = min;
            min = min.next;
            if (min != null)
                pq.add(min);
        }

        return outputHead;
    }

}
