
package tree;

import java.util.HashSet;

public class LCA {

    public int lca(TreeNode A, int B, int C) {
        HashSet<Integer> postorder = postorderTraversal(A); // check if both B and C are present
        if (!postorder.contains(B) || !postorder.contains(C))
            return -1;
        return lcaNode(A, B, C).val;
    }

    public HashSet<Integer> postorderTraversal(TreeNode A) {
        if (A == null) {
            return null;
        }
        HashSet<Integer> al = new HashSet<Integer>();
        HashSet<Integer> all = postorderTraversal(A.left);
        if (all != null)
            al.addAll(all);
        HashSet<Integer> alr = postorderTraversal(A.right);
        if (alr != null)
            al.addAll(alr);
        al.add(A.val);

        return al;
    }

    public TreeNode lcaNode(TreeNode root, int B, int C) {
        if (root == null) {
            return null;
        }
        if (root.val == B || root.val == C) {
            return root;
        }
        TreeNode leftLCA = lcaNode(root.left, B, C);
        TreeNode righLCA = lcaNode(root.right, B, C);
        if (leftLCA != null && righLCA != null) {
            return root;
        }
        if (leftLCA != null)
            return leftLCA;
        else
            return righLCA;
    }
}