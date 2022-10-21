package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    // below is first solution which has mentioned issue

    public static TreeMap<Integer, ArrayList<Integer>> verticalOrder(TreeNode root, int x,
            TreeMap<Integer, ArrayList<Integer>> map) {
        if (root == null)
            return null;
        verticalOrder(root.left, x - 1, map);

        if (map.containsKey(x)) {
            ArrayList<Integer> ll = map.get(x);
            ll.add(root.val);
            map.put(x, ll);
        } else {
            map.put(x, new ArrayList<Integer>(Arrays.asList(new Integer[] { root.val })));
        }
        verticalOrder(root.right, x + 1, map);
        return map;
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<>();
        verticalOrder(A, 0, hm);

        System.out.println(hm);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : hm.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = DeserializeBinaryTree.deserializeBT(new int[] { 460, 3871, 4698, 8399, 504, 4421, 7515, -1,
                4167, 5727, -1, -1, 3096, 434, 7389, 2667, 5661, 1969, 7815, 4292, 3006, 9750, 6693, -1, 6906, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 });

        VerticalOrderTraversal vo = new VerticalOrderTraversal();
        System.out.println(vo.verticalOrderTraversal2(root));

    }
    // exp
    // [8399 2667 1969 ] [3871 4167 5727 ] [460 504 4421 5661 7815 4292 9750 ] [4698
    // 3096 434 ] [7515 3006 6693 ] [7389 ] [6906 ]
    // act
    // [8399 2667 1969 ] [3871 4167 5727 ] [460 5661 504 7815 4421 4292 9750 ] [4698
    // 3096 434 ] [3006 7515 6693 ] [7389 ] [6906 ]
    // issue: nodes at same level must print in order of depth

    // second solution where queue is used for maintaining the order

    class Pair {
        int level;
        TreeNode node;

        Pair(TreeNode tn, Integer lvl) {
            level = lvl;
            node = tn;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal2(TreeNode A) {

        TreeMap<Integer, ArrayList<Integer>> freqMap = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        Pair root = new Pair(A, 0);
        q.add(root);

        while (!q.isEmpty()) {
            Pair top = q.remove();
            TreeNode curr = top.node;
            Integer level = top.level;

            if (freqMap.containsKey(level)) {
                ArrayList<Integer> arr = freqMap.get(level);
                arr.add(curr.val);
                freqMap.put(level, arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(curr.val);
                freqMap.put(level, arr);
            }

            if (curr.left != null) {
                Pair left = new Pair(curr.left, level - 1);
                q.add(left);
            }

            if (curr.right != null) {
                Pair right = new Pair(curr.right, level + 1);
                q.add(right);
            }

        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : freqMap.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

}
