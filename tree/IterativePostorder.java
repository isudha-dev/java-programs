package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class IterativePostorder {

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        TreeNode curr = A;
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        ArrayList<Integer> arr = new ArrayList<>();
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.peek();
                if (curr.right == null || curr.right == pre) {
                    arr.add(curr.val);
                    s.pop();
                    pre = curr;
                    curr = null;
                } else {
                    curr = curr.right;
                }
            }
        }
        return arr;
    }

    public ArrayList<Integer> postorderTraversalUsingPreorder(TreeNode A) {
        TreeNode curr = A;
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                arr.add(curr.val);
                s.push(curr);
                curr = curr.right;
            } else {
                curr = s.peek().left;
                s.pop();
            }
        }
        Collections.reverse(arr);
        return arr;
    }

}
