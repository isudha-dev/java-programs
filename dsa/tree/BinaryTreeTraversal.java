package dsa.tree;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeTraversal {

    // Definition for binary dsa.tree

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if (A == null) {
            return null;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<Integer> all = inorderTraversal(A.left);
        if (all != null)
            al.addAll(all);
        al.add(A.val);
        ArrayList<Integer> alr = inorderTraversal(A.right);
        if (alr != null)
            al.addAll(alr);

        return al;
    }

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        if (A == null) {
            return null;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(A.val);
        ArrayList<Integer> all = preorderTraversal(A.left);
        if (all != null)
            al.addAll(all);
        ArrayList<Integer> alr = preorderTraversal(A.right);
        if (alr != null)
            al.addAll(alr);

        return al;
    }

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        if (A == null) {
            return null;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<Integer> all = postorderTraversal(A.left);
        if (all != null)
            al.addAll(all);
        ArrayList<Integer> alr = postorderTraversal(A.right);
        if (alr != null)
            al.addAll(alr);
        al.add(A.val);

        return al;
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A == null || B == null) {
            return 0;
        }
        if ((A.val == B.val) && (isSameTree(A.left, B.left) == 1) && (isSameTree(A.right, B.right) == 1)) {
            return 1;
        } else {
            return 0;
        }
    }

    public int countGreaterAncestorNodes(TreeNode A) {
        return countGreaterAncestorNodesPrivate(A, Integer.MIN_VALUE);
    }

    private int countGreaterAncestorNodesPrivate(TreeNode A, int max) {
        if (A == null) {
            return 0;
        }

        int i = 0;
        if (A.val > max) {
            i = 1;
            max = A.val;
        }

        i += countGreaterAncestorNodesPrivate(A.left, max);
        i += countGreaterAncestorNodesPrivate(A.right, max);

        return i;
    }

    public int isSymmetric(TreeNode A) {

        TreeNode left = new TreeNode(A.val);
        left.left = A.left;

        TreeNode right = new TreeNode(A.val);
        right.right = A.right;

        return isSymmetric2(left, right);
    }

    private int isSymmetric2(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A == null || B == null) {
            return 0;
        }
        if (A.val == B.val) {
            if (isSymmetric2(A.left, B.right) == 1) {
                if (isSymmetric2(A.right, B.left) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public int bstNodesInRange(TreeNode A, int B, int C) {
        ArrayList<Integer> inorderT = inorderTraversal(A);
        int count = 0;
        for (Integer i : inorderT) {
            if (C >= i && i >= B) {
                count++;
            }
        }
        return count;

    }

    public TreeNode invertTree(TreeNode A) {
        if (A == null) {
            return null;
        }

        invertTree(A.left);
        invertTree(A.right);

        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;

        return A;
    }

    public ArrayList<Integer> pathToNode(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        pathToNodePrivate(A, B, ans);
        Collections.sort(ans);
        return ans;
    }

    private boolean pathToNodePrivate(TreeNode A, int B, ArrayList<Integer> ans) {

        if (A == null) {
            return false;
        }
        if (A.val == B) {
            ans.add(A.val);
            return true;
        }
        boolean isExist = pathToNodePrivate(A.left, B, ans) || pathToNodePrivate(A.right, B, ans);

        if (isExist) {
            ans.add(A.val);
        }

        return isExist;
    }

    public static void main(String[] args) {
        BinaryTreeTraversal it = new BinaryTreeTraversal();
        TreeNode root, left, right;
        root = it.new TreeNode(1);
        left = it.new TreeNode(9);
        right = it.new TreeNode(20);

        root.left = left;
        root.right = right;
        TreeNode tn = root;

        root = root.left;

        left = it.new TreeNode(11);
        right = it.new TreeNode(8);
        root.left = left;
        root.right = right;

        TreeNode tn1 = right;
        left = it.new TreeNode(4);
        tn1.left = left;

        root = tn.right;
        left = it.new TreeNode(15);
        right = it.new TreeNode(7);
        root.left = left;
        root.right = right;

        tn1 = right;
        left = it.new TreeNode(18);
        right = it.new TreeNode(12);
        tn1.left = left;
        tn1.right = right;

        ArrayList<Integer> ans = it.postorderTraversal(tn);
        System.out.println(ans);

    }

}
