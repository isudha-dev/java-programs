package dsa.practise.jul;

import java.util.Stack;

public class AddLinkedList {

//      Definition for singly-linked list.
    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode h1 = l1;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode h2 = l2;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);

        addTwoNumbers(h1, h2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();

        while (l1.next!=null){
            stk1.push(l1.val);
            l1 = l1.next;
        }

        while (l2.next!=null){
            stk2.push(l2.val);
            l2 = l2.next;
        }

        ListNode ans = new ListNode(0);
        int sum = 0;
        while(!stk1.empty() || !stk2.empty()){
            if(!stk1.isEmpty()){
                sum += stk1.pop();
            }
            if(!stk2.isEmpty()){
                sum+=stk2.pop();
            }
            ans.val = sum%10;
            ListNode head = new ListNode(sum/10);
            head.next = ans;
            ans = head;
            sum /= 10;
        }

        return ans.val == 0 ? ans.next : ans;

    }

}
