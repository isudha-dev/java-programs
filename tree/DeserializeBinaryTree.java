package tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {

    public static void main(String[] args) {

    }

    public static TreeNode deserializeBT(int[] A) {
        TreeNode root = new TreeNode(A[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int idx = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.peek();
            q.remove();
            if (curr == null)
                continue;
            int lVal = A[idx];
            int rVal = A[idx + 1];
            idx += 2;
            if (lVal == -1) {
                curr.left = null;
            } else {
                curr.left = new TreeNode(lVal);
            }
            if (rVal == -1) {
                curr.right = null;
            } else {
                curr.right = new TreeNode(rVal);
            }
            q.add(curr.left);
            q.add(curr.right);

        }

        return root;
    }

}
