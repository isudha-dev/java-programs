package dsa.tree;

import java.util.ArrayList;

public class RightViewofBT {

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

        solve(tn);

    }

    public static ArrayList<Integer> solve(TreeNode A) {

        ArrayList<ArrayList<Integer>> lvlAns = LevelOrder.levelOrder(A);
        ArrayList<Integer> ans = new ArrayList<>();
        for (ArrayList<Integer> row : lvlAns) {
            ans.add(row.get(row.size() - 1));
        }

        return ans;
    }

}
