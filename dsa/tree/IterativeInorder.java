package dsa.tree;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeInorder {

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        TreeNode curr = A;
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                arr.add(s.peek().val);
                curr = s.peek().right;
                s.pop();
            }
        }
        return arr;

    }

}
