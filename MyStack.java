import java.util.Deque;
import java.util.LinkedList;

public class MyStack {

    Deque<Integer> myStack;
    int size;

    public MyStack() {
        myStack = new LinkedList<>();
        size = myStack.size();
    }

    public void push(int x) {
        myStack.addFirst(x);
        size += 1;
    }

    public int pop() {
        size -= 1;
        return myStack.removeFirst();
    }

    public int top() {
        return myStack.peekFirst();

    }

    public boolean empty() {
        return (size == 0) ? true : false;
    }
}