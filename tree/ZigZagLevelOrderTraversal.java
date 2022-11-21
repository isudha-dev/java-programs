package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        q.add(A);
        q.add(null);
        boolean rightToLeft = false;
        while (!q.isEmpty()) {
            TreeNode top = q.peek();
            if (q.size() == 1 && top == null) {
                if (rightToLeft) {
                    Collections.reverse(temp);
                    rightToLeft = !rightToLeft;
                }
                ans.add(temp);
                break;
            }
            if (top == null) {
                q.remove();
                if (rightToLeft)
                    Collections.reverse(temp);
                ans.add(temp);
                rightToLeft = !rightToLeft;
                temp = new ArrayList<>();
                q.add(null);
                continue;
            }
            q.remove();
            temp.add(top.val);
            if (top.left != null)
                q.add(top.left);
            if (top.right != null)
                q.add(top.right);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = DeserializeBinaryTree
                .deserializeBT(new int[] { 1, 2, 3, 4, 5, 11, 6, -1, 7, -1, -1, -1, -1, -1, -1, 8, 9, -1, -1, -1, -1 });
        zigzagLevelOrder(root);
    }

}
