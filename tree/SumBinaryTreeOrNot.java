package tree;

public class SumBinaryTreeOrNot {

    public int solve(TreeNode A) {
        return isSumBinaryTree(A).isSumBt ? 1 : 0;
    }

    class Info {
        int sum;
        boolean isSumBt;

        Info() {
        }

        Info(int sum, boolean isSumBt) {
            this.sum = sum;
            this.isSumBt = isSumBt;
        }
    }

    public Info isSumBinaryTree(TreeNode A) {
        if (A == null) {
            return new Info(0, true);
        }
        if (A.left == null && A.right == null) {
            return new Info(A.val, true);
        }

        Info leftInfo = isSumBinaryTree(A.left);
        Info rightInfo = isSumBinaryTree(A.right);

        int sum = leftInfo.sum + rightInfo.sum + A.val;
        boolean isSumBt = leftInfo.isSumBt && rightInfo.isSumBt && (A.val == leftInfo.sum + rightInfo.sum);

        return new Info(sum, isSumBt);
    }

    public static void main(String[] args) {
        TreeNode root = DeserializeBinaryTree
                .deserializeBT(new int[] { 26, 10, 3, 4, 6, -1, 3, -1, -1, -1, -1, -1, -1 });
        SumBinaryTreeOrNot sm = new SumBinaryTreeOrNot();
        System.out.println(sm.solve(root));
    }

}
