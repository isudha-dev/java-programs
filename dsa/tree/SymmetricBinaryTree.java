package dsa.tree;

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode A) {

        return recursionHelper(A, A) ? 1 : 0;
    }

    public boolean recursionHelper(TreeNode lh, TreeNode rh) {

        if (lh == null || rh == null) {
            return lh == rh;
        }

        if (lh.val != rh.val) {
            return false;
        }

        return recursionHelper(lh.right, rh.left) && recursionHelper(lh.left, rh.right);
    }

}
