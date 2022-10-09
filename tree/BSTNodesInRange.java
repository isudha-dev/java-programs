package tree;

import java.util.Stack;

public class BSTNodesInRange {

    public static int solve(TreeNode A, int B, int C) {

        TreeNode curr = A;
        int count = 0;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                if (curr.val >= B && curr.val <= C)
                    count++;
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.peek().right;
                s.pop();
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TreeNode root = DeserializeBinaryTree
                .deserializeBT(new int[] { 32, 25, 46, 17, 27, 40, 49, 9, -1, -1, -1, -1, -1, -1, -1, -1, -1 });

        solve(root, 11, 26);
    }

}
