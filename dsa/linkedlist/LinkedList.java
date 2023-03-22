package dsa.linkedlist;

public class LinkedList {

    static Node head;
    static int length;

    public static class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public static void insert_node(int position, int value) {
        Node n1 = new Node(value);
        if (position > length + 1) {
            return;
        }
        if (position == 1 && head == null) {
            head = n1;
        } else if (position == 1 && head != null) {
            n1.next = head;
            n1 = head;
        } else {
            Node temp = head;
            int count = 1;
            while (count < position - 1) {
                temp = temp.next;
                count++;
            }
            n1.next = temp.next;
            temp.next = n1;
        }
        length++;
    }

    public static void delete_node(int position) {
        if (position > length) {
            return;
        }
        if (head != null) {
            if (position == 1) {
                head = head.next;
            } else {
                Node temp = head;
                int count = 1;
                while (count < position - 1) {
                    temp = temp.next;
                    count++;
                }
                temp.next = temp.next.next;
            }
            length--;
        }
    }

    public static void print_ll() {
        if (length == 0) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

}