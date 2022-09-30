package tree;

public class DiameterOfBT {

    int maxDiameter = Integer.MIN_VALUE;

    public int diameter(TreeNode A) {
        maxDiameter(A, 0);
        return maxDiameter;
    }

    public int maxDiameter(TreeNode root, int edge) {
        if (root == null)
            return 0;
        int left = maxDiameter(root.left, 0);
        int right = maxDiameter(root.right, 0);

        int sum2child = 1 + Math.max(Math.max(left, 0), Math.max(right, 0));
        int maxD = Math.max(left, 0) + Math.max(right, 0);
        maxDiameter = Math.max(maxDiameter, maxD);

        return sum2child;
    }

    public static void main(String[] args) {
        TreeNode root = DeserializeBinaryTree
                .deserializeBT(new int[] { 4, 8, 7, 13, 6, -1, -1, -1, -1, 9, 10, 12, -1, 2, 11, -1, 16, -1, -1, -1, 5,
                        20, -1, 1, -1, -1, -1, -1, 3, -1, -1 });
        DiameterOfBT dbt = new DiameterOfBT();
        dbt.diameter(root);
    }

}
