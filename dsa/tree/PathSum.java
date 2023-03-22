package dsa.tree;

import java.util.HashSet;

public class PathSum {

    HashSet<Integer> sums = new HashSet<>();

    public int hasPathSum(TreeNode A, int B) {

        pathSum(A, 0);

        return sums.contains(B) ? 1 : 0;
    }

    public int pathSum(TreeNode A, int rootSum) {
        if (A == null)
            return 0;

        int ansSum = A.val + rootSum;
        if (A.left == null && A.right == null) {
            sums.add(ansSum);
            return ansSum;
        }

        pathSum(A.left, ansSum);
        pathSum(A.right, ansSum);

        return ansSum;
    }

    public int hasPathSum1(TreeNode A, int B) {
        boolean status = sum(A, 0, B);
        return status ? 1 : 0;
    }

    public boolean sum(TreeNode A, int curSum, int reqSum) {
        if (A == null) {
            return false;
        }
        if (A.left == null && A.right == null) {
            curSum += A.val;
            if (curSum == reqSum)
                return true;
            return false;
        }
        int sum = curSum + A.val;
        return sum(A.left, sum, reqSum) || sum(A.right, sum, reqSum);
    }

    public static void main(String[] args) {
        // TreeNode root = DeserializeBinaryTree.deserializeBT(new int[] { 5, 4, 8, -11,
        // -1, -13, 4, -1, -1, -1, -1, -1, -1});

        // hasPathSum(root, -1);
    }

}
