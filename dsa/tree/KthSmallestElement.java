package dsa.tree;

import java.util.ArrayList;

public class KthSmallestElement {
    public static void main(String[] args) {

    }

    public int kthsmallest(TreeNode A, int B) {

        ArrayList<Integer> inorder = inorderTraversal(A);
        return inorder.get(B - 1);
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