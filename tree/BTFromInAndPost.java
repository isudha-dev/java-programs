package tree;

public class BTFromInAndPost {

    public static void main(String[] args) {
        buildTree(new int[] { 11, 9, 4, 8, 1, 15, 20, 18, 7, 12 }, new int[] { 11, 4, 8, 9, 15, 18, 12, 7, 20, 1 });
    }

    public static TreeNode buildTree(int[] A, int[] B) {

        TreeNode ans = bt_from_in_post(B, 0, B.length - 1, A, 0, A.length - 1);
        return ans;
    }

    public static TreeNode bt_from_in_post(int[] Post, int post_s, int post_e, int[] In, int in_s, int in_e) {
        if (post_s > post_e)
            return null;

        TreeNode root = new TreeNode(Post[post_e]);
        int idx = -1;

        // finding where root is present in InOrder
        for (int i = in_s; i <= in_e; i++) {
            if (In[i] == Post[post_e]) {
                idx = i;
                break;
            }
        }

        // right end in PostOrder
        int r = idx - in_s + post_s - 1;

        // LST
        root.left = bt_from_in_post(Post, post_s, r, In, in_s, idx - 1);

        // RST
        root.right = bt_from_in_post(Post, r + 1, post_e - 1, In, idx + 1, in_e);

        return root;
    }

}
