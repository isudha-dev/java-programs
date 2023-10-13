package dsa.stack;

import java.util.LinkedList;

public class Stack {
    int maxSize = 5;
    int[] stack = new int[maxSize];
    int top;
    void push(int e){
        if(top <= maxSize){
            top++;
            stack[top] = e;
        } else {
            System.out.println("Stack overflow");
        }
    }

    boolean isEmpty(){
        return top < 0;
    }

    int pop(){
        if(top < 0){
            System.out.println("Stack underflow");
        }
        int elem = stack[top];
        top--;
        return elem;
    }

    int peek(){
        if (top < 0){
            System.out.println("Stack underflow");
        }
        return stack[top];
    }

}
