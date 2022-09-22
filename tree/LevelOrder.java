package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {

        TreeNode root, left, right;
        root = new TreeNode(1);
        left = new TreeNode(12);
        right = new TreeNode(2);

        root.left = left;
        root.right = right;
        TreeNode tn = root;

        root = root.left;

        left = new TreeNode(10);
        right = new TreeNode(14);
        root.left = left;
        root.right = right;

        root = tn.right;
        left = new TreeNode(16);
        right = new TreeNode(27);
        root.left = left;
        root.right = right;

        levelOrder(tn);

    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        q.add(A);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode top = q.peek();
            if (q.size() == 1 && top == null) {
                ans.add(temp);
                break;
            }
            if (top == null) {
                q.remove();
                ans.add(temp);
                temp = new ArrayList<>();
                q.add(null);
                continue;
            }
            q.remove();
            temp.add(top.val); // System.out.println(top.val);
            if (top.left != null)
                q.add(top.left);
            if (top.right != null)
                q.add(top.right);
        }

        return ans;
    }

}
