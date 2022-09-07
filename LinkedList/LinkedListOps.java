package linkedlist;

public class LinkedListOps {

    public static void main(String[] args) {
        int num = 1;
        ListNode head = new ListNode(num);
        int len = 5;

        LinkedListOps llo = new LinkedListOps();
        while (len > 0) {
            llo.insertAtLast(head, ++num);
            len--;
        }

        num = 10;
        ListNode newHead = new ListNode(num);
        len = 2;
        while (len > 0) {
            llo.insertAtLast(newHead, ++num);
            len--;
        }

        System.out.println(llo.reverseListB(head, 2));

    }

    // Insert node at the last
    public ListNode insertAtLast(ListNode A, int val) {
        ListNode temp = A;
        ListNode newNode = new ListNode(val);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;

        return A;
    }

    // Delete middle node of a Linked List
    public ListNode deleteMiddleNode(ListNode A) {
        int len = getLen(A);
        if (len == 1) {
            A = null;
            return A;
        }
        deleteKthNode(A, len / 2 + 1);
        return A;
    }

    // Delete kth node
    public ListNode deleteKthNode(ListNode A, int k) {
        int len = getLen(A);
        if (k == 0 || k > len) {
            return null;
        }
        if (A == null) {
            return null;
        }
        if (len == 1 && k == 1) {
            A = null;
            return A;
        }
        int count = 1;
        ListNode temp = A;
        while (count < k - 1) {
            temp = temp.next;
            count++;
        }

        temp.next = temp.next.next;
        return A;
    }

    // Middle element of ll
    public int middleElement(ListNode A) {
        if (A == null) {
            return 0;
        }
        if (A.next == null) {
            return A.val;
        }
        int len = getLen(A);
        if (len == 2) {
            return A.next.val;
        }
        int mid = len / 2 + 1;

        ListNode temp = A;
        for (int i = 1; i < mid; i++) {
            temp = temp.next;

        }
        return temp.val;
    }

    // Length of ll
    public int getLen(ListNode A) {
        ListNode temp = A;
        if (A == null) {
            return 0;
        }

        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    // Reverse ll from position B to C
    public ListNode reverseBetween(ListNode A, int B, int C) {

        return null;
    }

    // Reverse ll
    public ListNode reverseList(ListNode A) {
        if (A == null) {
            return null;
        }
        if (A.next == null) {
            return A;
        }
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

    // Insert at head
    public void insertAtStart(ListNode A, int value) {
        if (A == null) {
            return;
        }
        ListNode newNode = new ListNode(value);
        newNode.next = A;
        A = newNode;

    }

    // Insert at Kth position
    public void insertAtKthPosition(int k, int value, ListNode A) {
        int len = getLen(A);
        if (k < 0 || k > len + 1) {
            return;
        }
        if (k == 1) {
            insertAtStart(A, value);
        }
        ListNode newNode = new ListNode(value);
        int idx = 1;
        ListNode temp = A;
        while (idx < k - 1) {
            temp = temp.next;
            idx++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // print all elements of ll
    public void printLl(ListNode A) {
        ListNode temp = A;
        while (temp != null) {
            System.out.println(temp.val + " ");
            temp = temp.next;
        }
    }

    // reverse B items in ll at a time
    public ListNode reverseListB(ListNode A, int B) {

        ListNode currTail = null;
        ListNode currHead = A;
        ListNode tempNode = currHead;

        while (tempNode != null) {
            for (int i = 1; i < B; i++) {
                tempNode = tempNode.next;
            }
            ListNode newHead = tempNode.next;
            currTail = tempNode;
            currTail.next = null;

            ListNode reversedHead = reverseList(currHead);
            A = insertListAtHead(reversedHead, newHead);
            currHead = newHead;
            tempNode = currHead;
        }

        return A;
    }

    // insert ll at the start of another ll
    public ListNode insertListAtHead(ListNode newList, ListNode oldList) {
        // traverse and get tail node of newList
        ListNode tempNode = newList;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }

        tempNode.next = oldList;
        return newList;
    }

    // insert ll at before given node
    public ListNode insertListBeforeNode(ListNode newList, ListNode oldList, int position) {

        return null;
    }

}