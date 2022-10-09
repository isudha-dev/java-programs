package tree;

public class DistanceBetNodesInBst {

    public int solve(TreeNode A, int B, int C) {
        if (B > C) {
            int temp = B;
            B = C;
            C = temp;
        }
        return distanceBetween2Nodes(A, B, C);
    }

    public int distanceFromRootToNode(TreeNode root, int x) {
        if (root.val == x)
            return 0;
        else if (root.val < x)
            return 1 + distanceFromRootToNode(root.right, x);
        else
            return 1 + distanceFromRootToNode(root.left, x);
    }

    public int distanceBetween2Nodes(TreeNode root, int x, int y) {
        if (root == null)
            return 0;
        if (root.val < x && root.val < y)
            return distanceBetween2Nodes(root.right, x, y);
        if (root.val > x && root.val > y)
            return distanceBetween2Nodes(root.left, x, y);

        // root.val >= x && root.val <= y
        return distanceFromRootToNode(root, x) + distanceFromRootToNode(root, y);
    }

}
