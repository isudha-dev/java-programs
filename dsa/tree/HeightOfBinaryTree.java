package dsa.tree;

public class HeightOfBinaryTree {

    public static int binaryTreeHeight(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int height = 0;
        height = Math.max(binaryTreeHeight(A.left), binaryTreeHeight(A.right)) + 1;

        return height;
    }

    public static void main(String[] args) {
        TreeNode root, left, right;
        root = new TreeNode(1);
        left = new TreeNode(2);
        right = new TreeNode(3);

        root.left = left;
        root.right = right;
        TreeNode tn = root;

        root = root.right;
        left = new TreeNode(4);
        root.left = left;

        root = root.left;
        right = new TreeNode(5);
        root.right = right;

        System.out.println(binaryTreeHeight(tn));

    }

}
