package tree;

import java.util.ArrayList;

public class CommonNodesSumInBST {

    public static int solve(TreeNode A, TreeNode B) {
        ArrayList<Integer> inA = inorderTraversal(A);
        ArrayList<Integer> inB = inorderTraversal(B);

        int p1 = 0, p2 = 0;
        long sum = 0;
        long mod = 1000000007L;
        while (p1 < inA.size() || p2 < inB.size()) {
            if (inA.get(p1) == inB.get(p2)) {
                sum += (long) (inA.get(p1)) % mod;
                p1++;
                p2++;
            } else if (inA.get(p1) < inB.get(p2))
                p1++;
            else
                p2++;

        }

        return (int) sum;

    }

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
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

    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.deserializeBT(new int[] { 5, 2, 8, -1, 3, -1, 15, -1, -1, 9, -1, -1, -1 });
        TreeNode B = DeserializeBinaryTree.deserializeBT(new int[] { 7, 1, 10, -1, 2, -1, 15, -1, -1, 11, -1, -1, -1 });
        System.out.println(solve(B, B));
    }

}
