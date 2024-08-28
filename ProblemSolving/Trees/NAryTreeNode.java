package ProblemSolving.Trees;

import java.util.List;

public class NAryTreeNode {
    int val;
    List<NAryTreeNode> children;

    public NAryTreeNode() {}

    public NAryTreeNode(int _val) {
        val = _val;
    }

    public NAryTreeNode(int _val, List<NAryTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
