package tree;

public class IdenticalBT {

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

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A == null || B == null) {
            return 0;
        }
        if ((A.val == B.val) && (isSameTree(A.left, B.left) == 1) && (isSameTree(A.right, B.right) == 1)) {
            return 1;
        } else {
            return 0;
        }
    }

    public int countGreaterAncestorNodes(TreeNode A) {
        return countGreaterNodes(A, 0, 0);
    }

    private int countGreaterNodes(TreeNode A, int max, int count) {
        if (A == null || A.val < max) {
            return 0;
        }

        if (A.val > max) {
            max = A.val;
            count++;

            count += countGreaterNodes(A.left, max, count);
            count += countGreaterNodes(A.right, max, count);
        }

        return count;

    }

    public static void main(String[] args) {

    }

}
