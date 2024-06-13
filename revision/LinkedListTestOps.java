package revision;

class Node {
    int val;
    Node next;

    Node(int val){
        this.val = val;
        next = null;
    }
}

public class LinkedListTestOps{
    public static void main(String[] args) {
        MyLinkedList llx = new MyLinkedList(1);
        Node head = llx.head;
        head.next = new Node(2);
        Node temp = head.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(5);
        temp = temp.next;
        temp.next = new Node(6);

        llx.reverseLL();

        System.out.println(llx.head.val);

    }

}

class MyLinkedList {

    Node head;
    MyLinkedList(int val){
        head = new Node(val);
    }


    // O(1), O(1)
    void insertAtStart(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }


    // O(1), O(1)
    void deleteAtHead(){
        if(head != null) {
            Node temp = head.next;
            head.next = null;
            head = temp;
        }
    }

    // O(N), O(1)
    void insertAtEnd(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next !=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // TODO keep a tail node - solution
    }

    // O(N), O(1)
    void deleteAtEnd(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
        }
        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    // O(K), O(1)
    void insertAtK(int val, int k){
        Node newNode = new Node(val);
        /*
            1 2 3 4 5
            k = 3
            1 2 N 3 4 5
            N -> 3
            2 -> N
         */
        if(head == null){
            return;
        }
        if(k == 1){
            insertAtStart(val);
        }
        Node temp = head;
        int count = 1;
        while (count<k-1){
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    void reverseLL(){
        /*
          p c n
            1 2 3 4 5 6
                        2 1 3 4 5 6
            2 1 3 4 5 6
            6 5 4 3 2 1

            ll1 = 1
            ll2 = 2 3 4 5 6

            ll1.insertAtHead(2)
            ll2.deleteAtHead()
          */

        Node prev = null, curr = head, next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

    }





}


