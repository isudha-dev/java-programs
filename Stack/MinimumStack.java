package stack;

import java.util.Stack;

public class MinimumStack {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        if (mainStack.isEmpty()) {
            return;
        }
        minStack.pop();
        mainStack.pop();
    }

    public int top() {
        if (mainStack.isEmpty()) {
            return -1;
        }
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

}
