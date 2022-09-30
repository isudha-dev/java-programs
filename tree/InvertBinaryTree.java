package tree;

public class InvertBinaryTree {

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public static TreeNode invertTree(TreeNode A) {

        return invert(A);
    }

    public static TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
        } else if (root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
        }

        invert(root.left);
        invert(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = DeserializeBinaryTree
                .deserializeBT(new int[] { 7, 2, -1, 1, 4, -1, -1, 3, 5, -1, -1, -1, 6, -1, -1 });

        TreeNode newNode = invertTree(root);
        System.out.println(newNode);
    }

}
