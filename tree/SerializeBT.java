package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBT {

    public static ArrayList<Integer> levelOrder(TreeNode A) {

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ansArr = new ArrayList<>();

        q.add(A);
        while (!q.isEmpty()) {
            TreeNode top = q.peek();
            q.remove();

            if (top == null) {
                ansArr.add(-1);
                continue;
            }
            ansArr.add(top.val);

            q.add(top.left);
            q.add(top.right);
        }

        return ansArr;
    }

    public static void main(String[] args) {
        TreeNode root = DeserializeBinaryTree
                .deserializeBT(new int[] { 1, 2, 3, 4, 5, 11, 6, -1, 7, -1, -1, -1, -1, -1, -1, 8, 9, -1, -1, -1, -1 });
        ArrayList<Integer> ans = levelOrder(root);
        System.out.println(ans);
    }
}
