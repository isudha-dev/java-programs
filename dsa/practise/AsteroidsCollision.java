package dsa.practise;

import java.util.ArrayList;
import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
public class AsteroidsCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <asteroids.length; i++) {
            if(!stack.empty()){
                int top = stack.peek();
                if(top < 0 && asteroids[i] > 0 || top > 0 && asteroids[i] < 0) { // opposite direction
                    if(Math.abs(top) < Math.abs((asteroids[i]))){
                        while (Math.abs(top) < Math.abs((asteroids[i]))){ // keep popping top element
                            stack.pop();
                            if(!stack.isEmpty()){
                                top = stack.peek();
                            } else {
                                break;
                            }
                        }
                    } else if (Math.abs(top) == Math.abs((asteroids[i]))) {
                        stack.pop();
                    }
                } else { // same direction
                    stack.push(asteroids[i]);
                }
            } else { // new element
                stack.push(asteroids[i]);
            }
        }
        int[] ans = new int[stack.size()];
        int i = stack.size()-1;
        while (stack.size() > 0){
            ans[i] = stack.pop();
            i--;
        }
        return ans;
    }

    // + right, - left
    public static int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< asteroids.length; i++){
            if(asteroids[i] > 0){
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (asteroids[i] + stack.peek() == 0) {
                    stack.pop();
                }
            }
        }

        int[] ans = new int[stack.size()];
        int i = stack.size()-1;
        while (stack.size() > 0){
            ans[i] = stack.pop();
            i--;
        }
        return ans;
    }
    public static void main(String[] args) {
        asteroidCollision1(new int[] {-2,-1,1,2});
        //5,10,-5
    }
}
