package dsa.tree;

public class BalancedBT {

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        height = Math.max(height(root.left), height(root.right)) + 1;

        return height;
    }

    public boolean isBalancedHeight(TreeNode root) {
        if (root == null)
            return true;
        int hl = height(root.left);
        int hr = height(root.right);

        if (Math.abs(hl - hr) <= 1 && isBalancedHeight(root.left) && isBalancedHeight(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    public int isBalanced(TreeNode A) {
        return isBalancedHeight(A) ? 1 : 0;
    }

    public static void main(String[] args) {

        TreeNode root = DeserializeBinaryTree.deserializeBT(new int[] { 1, -1, 2, -1, -1 });

        BalancedBT bb = new BalancedBT();
        System.out.println(bb.isBalanced(root));

    }

}
