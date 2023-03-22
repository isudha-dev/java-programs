package dsa.tree;

public class SortedArrToBBST {

    public TreeNode sortedArrayToBST(final int[] A) {
        return createBBST(A, 0, A.length - 1);
    }

    public TreeNode createBBST(int[] A, int l, int r) {
        if (l > r)
            return null;

        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = createBBST(A, l, mid - 1);
        root.right = createBBST(A, mid + 1, r);

        return root;
    }

}
