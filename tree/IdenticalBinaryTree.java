package tree;

import java.util.ArrayList;

public class IdenticalBinaryTree {

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return 1;
        if (A == null || B == null) {
            return 0;
        }

        ArrayList<Integer> arrA = inorderTraversal(A);
        ArrayList<Integer> arrB = inorderTraversal(B);

        return arrA.equals(arrB) ? 1 : 0;
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

    public static void main(String[] args) {
        IdenticalBinaryTree ibt = new IdenticalBinaryTree();
        ibt.isSameTree(DeserializeBinaryTree.deserializeBT(new int[] { 0, -1, -1 }),
                DeserializeBinaryTree.deserializeBT(new int[] { 0, -1, -1 }));
    }

}
