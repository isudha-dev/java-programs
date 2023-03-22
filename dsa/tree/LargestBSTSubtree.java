package dsa.tree;

public class LargestBSTSubtree {

    public static void main(String[] args) {

        // 10, 5, 15, 1, 8, -1, 7, -1, -1, -1, -1, -1, -1
        TreeNode root = DeserializeBinaryTree
                .deserializeBT(new int[] { 20, 14, 12, 11, -1, -1, -1, -1, -1 });

        LargestBSTSubtree lbs = new LargestBSTSubtree();
        System.out.println(lbs.solve(root));
    }

    class Pair {
        boolean isBST;
        int size;
        int min;
        int max;

        Pair(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    int maxSize = 0;

    public int solve(TreeNode A) {

        helpFunc(A);
        return maxSize;
    }

    public Pair helpFunc(TreeNode node) {
        if (node == null) {
            return new Pair(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Pair l = helpFunc(node.left);
        Pair r = helpFunc(node.right);

        if (l.isBST && r.isBST && node.val > l.max && node.val < r.min) {
            int size = 1 + l.size + r.size;
            maxSize = Math.max(maxSize, size);
            return new Pair(true, size, Math.min(node.val, l.min), Math.max(node.val, r.max));

        } else {
            return new Pair(false, 0, 0, 0);
        }

    }

    public int isBST(TreeNode root, int min, int max) {
        if (root == null)
            return 0;
        if (root.val < min || root.val > max) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = isBST(root.left, min, root.val - 1);
        int right = isBST(root.right, root.val + 1, max);

        if (left > 0 && right > 0) {
            return left + right + 1;
        } else if (left > 0 && right == 0) {
            return left;
        } else if (right > 0 && left == 0) {
            return right;
        } else {
            return 0;
        }
    }

}
