package dsa.tree;

public class EqualTreePartition {

    public int solve(TreeNode A) {

        int totSum = findTotalSum(A);
        boolean possible = isPossible(A, totSum);
        return possible ? 1 : 0;
    }

    public int findTotalSum(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return A.val + findTotalSum(A.right) + findTotalSum(A.left);
    }

    public boolean isPossible(TreeNode root, int totalSum) {
        if (root == null) {
            return false;
        }
        int leftSum = findTotalSum(root.left);
        int rightSum = findTotalSum(root.right);
        if (leftSum * 2 == totalSum || rightSum * 2 == totalSum) {
            // possible = 1;
            return true;
        } else {
            return isPossible(root.left, totalSum) || isPossible(root.right, totalSum);
        }
    }

}
