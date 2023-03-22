package dsa.tree;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePreorder {

    public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        TreeNode curr = A;
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                arr.add(curr.val);
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.peek().right;
                s.pop();
            }
        }
        return arr;

    }
}
