package dsa.tree;

public class BTFromInAndPre {

    public static TreeNode buildTree(int[] A, int[] B) {
        // A post order, B in order
        TreeNode ans = bt_from_in_pre(A, 0, A.length - 1, B, 0, B.length - 1);
        return ans;
    }

    public static TreeNode bt_from_in_pre(int[] Pre, int pre_s, int pre_e, int[] In, int in_s, int in_e) {
        if (pre_s > pre_e)
            return null;

        TreeNode root = new TreeNode(Pre[pre_s]);
        int idx = -1;

        // finding where root is present in InOrder
        for (int i = in_s; i <= in_e; i++) {
            if (In[i] == Pre[pre_s]) {
                idx = i;
                break;
            }
        }

        // right end in PostOrder
        int r = pre_s + idx - in_s;

        // LST
        root.left = bt_from_in_pre(Pre, pre_s + 1, r, In, in_s, idx - 1);

        // RST
        root.right = bt_from_in_pre(Pre, r + 1, pre_e, In, idx + 1, in_e);

        return root;
    }

}
