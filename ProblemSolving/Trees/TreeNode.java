package ProblemSolving.Trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    int depth;
    int height;

    public TreeNode(){

    }

    public TreeNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
