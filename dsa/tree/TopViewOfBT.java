package dsa.tree;

import java.util.ArrayList;

public class TopViewOfBT {

    public ArrayList<Integer> solve(TreeNode A) {

        VerticalOrderTraversal voCls = new VerticalOrderTraversal();
        ArrayList<ArrayList<Integer>> vo = voCls.verticalOrderTraversal2(A);
        ArrayList<Integer> ans = new ArrayList<>();
        for (ArrayList<Integer> i : vo) {
            ans.add(i.get(0));
        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = DeserializeBinaryTree.deserializeBT(new int[] { 460, 3871, 4698, 8399, 504, 4421, 7515, -1,
                4167, 5727, -1, -1, 3096, 434, 7389, 2667, 5661, 1969, 7815, 4292, 3006, 9750, 6693, -1, 6906, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 });

        TopViewOfBT vo = new TopViewOfBT();
        System.out.println(vo.solve(root));

    }

}
