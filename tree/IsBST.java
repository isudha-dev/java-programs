package tree;

public class IsBST {

    public int isValidBST(TreeNode A) {

        return isBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    public boolean isBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val < min || root.val > max) {
            return false;
        }
        return isBST(root.left, min, root.val - 1) && isBST(root.right, root.val + 1, max);
    }

}
