package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBT {

    public static void main(String[] args) {
        TreeNode root, left, right;
        root = new TreeNode(1);
        left = new TreeNode(3);
        right = new TreeNode(2);

        root.left = left;
        root.right = right;
        TreeNode tn = root;

        root = root.left;

        left = new TreeNode(5);
//        right = new TreeNode(14);
        root.left = left;
//        root.right = right;
        TreeNode leftTn = root;

        root = tn.right;
//        left = new TreeNode(16);
        right = new TreeNode(9);
//        root.left = left;
        root.right = right;
        TreeNode rightTn = root;

        root = leftTn.left;
        left = new TreeNode(6);
        root.left = left;

        root = rightTn.right;
        left = new TreeNode(7);
        root.left = left;

        System.out.println(widthOfBinaryTree(tn));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            int levelStart = queue.peek().getValue();
            int index = 0;

            for (int i = 0; i < levelLength; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                index = pair.getValue();

                if (node.left != null) {
                    queue.add(new Pair<>(node.left, 2*index));
                }

                if (node.right != null) {
                    queue.add(new Pair<>(node.right, 2*index+1));
                }
            }

            maxWidth = Math.max(maxWidth, index - levelStart + 1);
        }

        return maxWidth;

    }

    static class TreeNodeIndex{
        TreeNode node;
        int index;

        public TreeNodeIndex(final TreeNode node, final int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode tn) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Queue<TreeNodeIndex> q = new LinkedList<>();

        q.add(new TreeNodeIndex(tn, 0));
        q.add(null);

        int maxLen = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            TreeNodeIndex top = q.peek();
            int idx = top.index;
            if(q.size() == 1 && top == null){
                ans.add(temp);
                break;
            }
            if(top == null){
                q.remove();
                ans.add(temp);
                temp = new ArrayList<>();
                q.add(null);
                continue;
            }
            q.remove();
            temp.add(top.node.val);

            if(top.node.left !=null){
                q.add(new TreeNodeIndex(top.node.left, idx*0 ));
            }
            if(top.node.right != null){
                q.add(new TreeNodeIndex(top.node.right, idx*1+1 ));
            }
        }

        return ans;

    }

}
