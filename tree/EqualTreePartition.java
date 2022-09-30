package tree;

import java.util.ArrayList;

public class EqualTreePartition {

    public int solve(TreeNode A) {

        ArrayList<Integer> postorder = postorderTraversal(A);
        int sum = 0;
        for (int i : postorder) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return 0;
        }
        int halfSum = 0;

        for (int i : postorder) {
            halfSum += i;
            if (halfSum == sum / 2) {
                return 1;
            }
        }

        return 0;
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

}
