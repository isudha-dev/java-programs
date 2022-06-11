package Stack;

import java.util.LinkedList;

public class MinStack {

    LinkedList<Integer> ll = new LinkedList<>();
    long min = Long.MAX_VALUE;

    public void push(int x) {
        if (ll.isEmpty()) {
            min = x;
        }
        if (x < min) {
            ll.add((int) (2 * x - min));
            min = x;
        } else
            ll.add(x);
    }

    public void pop() {
        if (!ll.isEmpty()) {
            int ele = ll.getLast();
            if (ele < min) {
                min = (2 * min - ele);
            }
            ll.removeLast();
        }
    }

    public int top() {
        if (!ll.isEmpty()) {
            int ele = ll.getLast();
            if (ele < min) {
                return (int) min;
            } else {
                return ele;
            }
        } else
            return -1;
    }

    public int getMin() {
        return ll.isEmpty() ? -1 : (int) min;
    }

    public int getSize() {
        return ll.size();
    }

    public void printStack() {
        int i = ll.size();
        for (int k = i; k >= 0; k--) {
            ll.get(k);
        }
    }

}
