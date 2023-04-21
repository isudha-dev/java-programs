package dsa.tree;

import java.util.HashMap;

//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
public class LongestZigZagPathInBTLC {

    
    int maxLen = Integer.MIN_VALUE;
    public int longestZigZag(TreeNode root) {
        HashMap<TreeNode, Integer[]> map = new HashMap<>();
        dfs(root, new HashMap<>());
        return maxLen;
    }

    public  void dfs(TreeNode node, HashMap<TreeNode, int[]> map){
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null){
            map.put(node, new int[] {0,0});
            return;
        }

        dfs(node.left, map);
        dfs(node.right, map);

        int l = 0, r = 0;

        if(map.get(node.left) != null){
            l = 1 + map.get(node.left)[1];
        }
        if(map.get(node.right) != null){
            r = 1 + map.get(node.right)[0];
        }

        map.put(node, new int[] {l, r});

        maxLen = Math.max(maxLen, Math.max(l, r));

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
