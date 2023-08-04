package dsa.practise;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBT {

    static class TreeNode {
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

    public static List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }

        for(int i = 1; i < n; i+=2){
            List<TreeNode> leftSubTree = allPossibleFBT(i);
            List<TreeNode> rightSubTree = allPossibleFBT(n-1-i);

            for(TreeNode lNode : leftSubTree) {
                for(TreeNode rNode : rightSubTree) {
                    TreeNode root = new TreeNode(0);
                    root.left = lNode;
                    root.right = rNode;
                    ans.add(root);
                }
            }
        }

        return ans;

    }

}
