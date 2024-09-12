package concepts.collection;

public class CustomLinkedList {

    ListNode head;
    ListNode tail;
    int size;

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public CustomLinkedList(int val) {
        head = new ListNode(val);
        tail = head;
        size = 1;
    }

    public void addAtStart(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void deleteAtStart() {
        head = head.next;
        size--;
    }

    public void add(int val) {
        addAtEnd(val);
    }

    public void addAtEnd(int val) {
        ListNode newNode = new ListNode(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    // 0 based values
    public void insertAtK(int k, int val) {
        if(k >= size) {
            addAtEnd(val);
            return;
        }
        ListNode temp = head;
        while (k>0) {
            temp = temp.next;
            k--;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtK(int k) {
        if(k >= size)
            return;

        ListNode temp = head;
        while (k >= 1) {
            temp = temp.next;
            k--;
        }
        if(temp.next == tail)
            temp = temp;

        temp.next = temp.next.next;
    }

    public void deleteAtEnd() {
        deleteAtK(size-1);
    }

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList(1);
        linkedList.add(2);
        linkedList.addAtStart(0);
        System.out.println(linkedList.size);
    }

}
