package ProblemSolving;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProblemSolving_2Jul24 {

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = treeNode;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> currLevel = new ArrayList<>();
        queue.add(treeNode);
        queue.add(null);

        while (!queue.isEmpty()){
            curr = queue.poll();
            if(curr == null){
                ans.add(currLevel);
                if(queue.isEmpty()){
                    break;
                } else {
                    currLevel = new ArrayList<>();
                    queue.add(null);
                }
            } else {
                currLevel.add(curr.getVal());
                if(curr.getLeft() != null){
                    queue.add(curr.getLeft());
                }
                if(curr.getRight() != null){
                    queue.add(curr.getRight());
                }
            }
        }

        return ans;
    }
}
