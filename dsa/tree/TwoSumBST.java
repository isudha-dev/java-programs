package dsa.tree;

import java.util.HashSet;
import java.util.Stack;

public class TwoSumBST {
    public static int t2Sum(TreeNode A, int B) {
        TreeNode curr = A;
        Stack<TreeNode> s = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                int exp = B - curr.val;
                if (set.contains(exp))
                    return 1;
                set.add(curr.val);
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.peek().right;
                s.pop();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = DeserializeBinaryTree.deserializeBT(new int[] { 10, 9, 20, -1, -1, -1, -1 });
        t2Sum(root, 19);
    }

}
