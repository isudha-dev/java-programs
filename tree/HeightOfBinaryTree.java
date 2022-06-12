package tree;

public class HeightOfBinaryTree {

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

    public int binaryTreeHeight(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int height = 0;
        height = Math.max(binaryTreeHeight(A.left), binaryTreeHeight(A.right)) + 1;

        return height;
    }

    public static void main(String[] args) {
        HeightOfBinaryTree bt = new HeightOfBinaryTree();
        TreeNode root, left, right;
        root = bt.new TreeNode(1);
        left = bt.new TreeNode(2);
        right = bt.new TreeNode(3);

        root.left = left;
        root.right = right;
        TreeNode tn = root;

        root = root.right;
        left = bt.new TreeNode(4);
        root.left = left;

        root = root.left;
        right = bt.new TreeNode(5);
        root.right = right;

        System.out.println(bt.binaryTreeHeight(tn));

    }

}
