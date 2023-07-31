package dsa.practise.jul.ll;

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

    public static void main(String[] args) {

    }

}
