package tree;

import java.util.ArrayList;

public class BinaryTreeTraversal {

    // Definition for binary tree

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
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

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        if (A == null) {
            return null;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(A.val);
        ArrayList<Integer> all = preorderTraversal(A.left);
        if (all != null)
            al.addAll(all);
        ArrayList<Integer> alr = preorderTraversal(A.right);
        if (alr != null)
            al.addAll(alr);

        return al;
    }

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        if (A == null) {
            return null;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<Integer> all = postorderTraversal(A.left);
        if (all != null)
            al.addAll(all);
        ArrayList<Integer> alr = postorderTraversal(A.right);
        if (alr != null)
            al.addAll(alr);
        al.add(A.val);

        return al;
    }

    public static void main(String[] args) {
        BinaryTreeTraversal it = new BinaryTreeTraversal();
        TreeNode root, left, right;
        root = it.new TreeNode(1);
        left = it.new TreeNode(2);
        right = it.new TreeNode(3);

        root.left = left;
        root.right = right;
        TreeNode tn = root;

        root = root.right;
        left = it.new TreeNode(4);
        root.left = left;

        root = root.left;
        right = it.new TreeNode(5);
        root.right = right;

        ArrayList<Integer> ansInorder = it.inorderTraversal(tn);
        System.out.println(ansInorder);

        ArrayList<Integer> ansPreorder = it.preorderTraversal(tn);
        System.out.println(ansPreorder);

        ArrayList<Integer> ansPostorder = it.postorderTraversal(tn);
        System.out.println(ansPostorder);

    }

}
