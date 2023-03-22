package dsa.tree;

import java.util.ArrayList;

public class RecoverBST {

    int prev = Integer.MIN_VALUE, maxDip, minDip;
    boolean flag = true;

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (root.val < prev && flag) {
            maxDip = prev;
            minDip = root.val;
            flag = false;
        } else if (root.val < prev) {
            minDip = root.val;
        }
        prev = root.val;
        inorder(root.right);

    }

    public int[] recoverTree(TreeNode A) {

        inorder(A);

        return new int[] { maxDip, minDip };
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if (A == null) {
            return null;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<Integer> all = inorderTraversal(A.left);
        if (all != null)
            al.addAll(all);
        al.add(A.val);
        ArrayList<Integer> alr = inorderTraversal(A.right);
        if (alr != null)
            al.addAll(alr);

        return al;
    }

}
