package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class OddEvenLevelSum {

    public static int solve(TreeNode A) {

        Queue<TreeNode> q = new LinkedList<>();
        int sumOdd = 0, sumEven = 0;
        boolean evenFlag = false;
        q.add(A);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode top = q.peek();
            if (q.size() == 1 && top == null) {
                break;
            }
            if (top == null) {
                q.remove();
                evenFlag = !evenFlag;
                q.add(null);
                continue;
            }
            q.remove();
            if (evenFlag)
                sumEven += top.val;
            else
                sumOdd += top.val;

            if (top.left != null)
                q.add(top.left);
            if (top.right != null)
                q.add(top.right);
        }
        return sumOdd - sumEven;
    }

    public static void main(String[] args) {
        TreeNode root = DeserializeBinaryTree
                .deserializeBT(new int[] { 2, 10, 2, 4, -1, -1, -1, -1, -1 });
        int ans = solve(root);
        System.out.println(ans);
    }
}
