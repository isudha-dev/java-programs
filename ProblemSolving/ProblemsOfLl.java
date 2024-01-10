package ProblemSolving;

public class ProblemsOfLl {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode temp = A;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;
        temp.next = new ListNode(6);

        rotateRight(A, 90);
    }

    public static ListNode rotateRight(ListNode A, int B) {
        if(A == null){
            return null;
        }
        int size = 1;

        ListNode temp = A;
        while(temp.next!=null){
            size++;
            temp=temp.next;
        }

        if(B>size) {
            B = B%size;
        }

        if(B == 0) {
            return A;
        }

        temp = A;
        ListNode prev = temp;
        for(int i = 0; i<(size-B); i++){
            prev = temp;
            temp = temp.next;
        }

        ListNode secondPart = temp;
        prev.next = null;


        for(int i = 1; i<B; i++){
            temp = temp.next;
        }
        temp.next = A;

        return secondPart;
    }

}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

