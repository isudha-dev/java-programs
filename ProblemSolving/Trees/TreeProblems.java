package ProblemSolving.Trees;

import java.util.*;

public class TreeProblems {

    public static void main(String[] args) {
        TreeNode main = new TreeNode(1);
        TreeNode root = main;
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        main.left = left;
        main.right = right;

        TreeNode temp = right;

        main = left;
        left = new TreeNode(4);
        right = new TreeNode(5);
        main.left = left;
        main.right = right;

        main = temp;
        left = new TreeNode(6);
        right = new TreeNode(7);
        main.left = left;
        main.right = right;

        main = right;
        right = new TreeNode(8);
        main.right = right;

        // 460 3871 4698 8399 504 4421 7515 -1 4167 5727 -1 -1 3096 434 7389 2667 5661 1969 7815 4292 3006 9750 6693 -1 6906 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
        // ex [8399 2667 1969 ] [3871 4167 5727 ] [460 504 4421 5661 7815 4292 9750 ] [4698 3096 434 ] [7515 3006 6693 ] [7389 ] [6906 ]
        // ac [8399 2667 1969 ] [3871 4167 5727 ] [460 5661 504 7815 4421 4292 9750 ] [4698 3096 434 ] [3006 7515 6693 ] [7389 ] [6906 ]

//        int ans = maxSumPath(root);
//        System.out.println(ans);
        /*
                      1
                2           3
            4       5   6       7
                                    8
         */

        System.out.println("Preorder");
        ArrayList<TreeNode> pro = preorderIterative(root);
        pro.forEach(i -> System.out.print(i+" "));

        System.out.println("\nInorder");
        ArrayList<TreeNode> io = inorderIterative(root);
        io.forEach(i -> System.out.print(i+" "));

        System.out.println("\nPostorder");
        ArrayList<TreeNode> po = postOrderIterative(root);
        po.forEach(i -> System.out.print(i+" "));
        System.out.println();

        po = postOrderIterativeUsingPreorder(root);
        po.forEach(i -> System.out.print(i+" "));
        System.out.println();

        ArrayList<Integer> poI = postOrderIterativeWith2Stacks(root);
        poI.forEach(i -> System.out.print(i+" "));

        System.out.println("\nLevel order");
        levelOrderTraversal(root);
    }

    /*
                1
            2       3
        4       5       6
                            7

       preorder =   1 2 4 5 3 6 7   Rt L R
       inorder =    4 2 5 1 3 6 7   L Rt R
       postorder =  4 5 2 7 6 3 1   L R Rt

       root 1
          2   3
        4   5   6
                    7
       left side    4 2 5
       right side   3 6 7

                1
            2         3
        4       5 6       7
                              8

        preorder = rt L R = 1 2 4 5 3 6 7 8
        inorder =   L rt R = 4 2 5 1 6 3 7 8
        postorder = L R rt = 4 5 2 6 8 7 3 1

       */

    public static int maxSumPath(TreeNode root){
        List<Integer> maxSum = new ArrayList<>();
        maxSumPath(root, maxSum);
        return maxSum.stream().reduce(Math::max).get();
    }

    public static int maxSumPath(TreeNode root, List<Integer> maxSum){
        if(root == null){
            return 0;
        }

        int leftChildSum = maxSumPath(root.left, maxSum);
        int rightChildSum = maxSumPath(root.right, maxSum);

        int maxSumOneChild = root.val + Math.max(0, Math.max(leftChildSum, rightChildSum));
        int maxSumTwoChild = root.val + Math.max(leftChildSum, 0) + Math.max(rightChildSum, 0);

        maxSum.add(maxSumTwoChild);

        return maxSumOneChild;
    }

    public static int isHeightBalanced(TreeNode A) {
        return isHeightBalancedPreorder(A) ? 1 : 0 ;
    }

    public static int height(TreeNode A){
        if(A == null){
            return 0;
        }

        return Math.max(height(A.left), height(A.right))+1;
    }

    public static boolean isHeightBalancedPreorder(TreeNode A){
        if(A == null)
            return true;

        int left = height(A.left);
        int right = height(A.right);


        if(Math.abs(left - right) <= 1 && isHeightBalancedPreorder(A.left) && isHeightBalancedPreorder(A.right)){
            return true;
        }

        return false;
    }

    public static ArrayList<Integer> serializeBinaryTree(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int idx = 0;
        queue.add(A);

        while (!queue.isEmpty()){
            TreeNode top = queue.poll();
            if(top != null){
                ans.add(idx, top.val);
                idx++;
            } else {
                ans.add(-1);
                idx++;
                continue;
            }

            if(top.left != null){
                queue.add(top.left);
            } else {
                queue.add(null);
            }

            if(top.right != null){
                queue.add(top.right);
            } else {
                queue.add(null);
            }
        }

        return ans;
    }

    public static TreeNode buildTreeFromInorderPreorder(ArrayList<Integer> io, ArrayList<Integer> po){
        if(io.size() == 1){
            return new TreeNode(io.get(0));
        }
        int n = io.size();
        TreeNode root = new TreeNode(po.get(0));

        ArrayList<Integer> lst = new ArrayList<>();
        int i = 0;
        while (io.get(i) != po.get(0)){
            lst.add(io.get(i));
            i++;
        }

        i++;
        ArrayList<Integer> rst = new ArrayList<>();
        while (i < n){
            rst.add(io.get(i));
            i++;
        }

        if(lst.size() > 0){
            ArrayList<Integer> poLst = new ArrayList<>(po.subList(1, lst.size()+1));
            root.left = buildTreeFromInorderPreorder(lst, poLst);
        }

        if(rst.size() > 0){
            ArrayList<Integer> poRst = new ArrayList<>(po.subList(lst.size()+1, n));
            root.right = buildTreeFromInorderPreorder(rst, poRst);
        }

        return root;
    }


    public static TreeNode buildTreeFromLevelOrder(ArrayList<Integer> A) {
        // 1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1 | 2*prev nodes count
        // 1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1 |
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, 10, 11, -1, 12, 13

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(A.get(0));
        queue.add(root);

        int idx = 1;
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if (curr == null){
                continue;
            }

            int left = A.get(idx);
            int right = A.get(idx+1);
            idx += 2;

            if(left == -1){
                curr.left = null;
            } else {
                curr.left = new TreeNode(left);
            }

            if(right == -1){
                curr.right = null;
            } else {
                curr.right = new TreeNode(right);
            }

            queue.add(curr.left);
            queue.add(curr.right);
        }
        return root;
    }

    public static TreeNode buildTreeFromInorderPostorder(ArrayList<Integer> io, ArrayList<Integer> po) {
        if(io.size() == 1){
            return new TreeNode(io.get(0));
        }

        int n = io.size();

        TreeNode root = new TreeNode(po.get(n-1));
        ArrayList<Integer> lst = new ArrayList<>();
        ArrayList<Integer> rst = new ArrayList<>();

        int i = 0;
        while (io.get(i) != root.val){
            lst.add(io.get(i));
            i++;
        }

        i++;

        while (i < n){
            rst.add(io.get(i));
            i++;
        }

        if(!lst.isEmpty()){
            ArrayList<Integer> poLst = new ArrayList<>(po.subList(0, lst.size()));
            root.left = buildTreeFromInorderPostorder(lst, poLst);
        }

        if(!rst.isEmpty()){
            ArrayList<Integer> poRst = new ArrayList<>(po.subList(lst.size(), n-1));
            root.right = buildTreeFromInorderPostorder(rst, poRst);
        }

        return root;
    }

    public static ArrayList<TreeNode> preOrderRecursive(TreeNode root){
        ArrayList<TreeNode> ansList = new ArrayList<>();
        preOrderRecursiveHelper(root, ansList);
        return ansList;
    }

    public static void preOrderRecursiveHelper(TreeNode node, ArrayList<TreeNode> ansList){
        if(node == null)
            return;

        ansList.add(node);
        preOrderRecursiveHelper(node.left, ansList);
        preOrderRecursiveHelper(node.right, ansList);
    }

    public static ArrayList<TreeNode> inOrderRecursive(TreeNode root){
        ArrayList<TreeNode> ansList = new ArrayList<>();
        inOrderRecursiveHelper(root, ansList);
        return ansList;
    }

    public static void inOrderRecursiveHelper(TreeNode node, ArrayList<TreeNode> ansList){
        if(node == null)
            return;

        inOrderRecursiveHelper(node.left, ansList);
        ansList.add(node);
        inOrderRecursiveHelper(node.right, ansList);
    }

    public static ArrayList<TreeNode> postOrderRecursive(TreeNode root){
        ArrayList<TreeNode> ansList = new ArrayList<>();
        postOrderRecursiveHelper(root, ansList);
        return ansList;
    }

    private static void postOrderRecursiveHelper(TreeNode node, ArrayList<TreeNode> ansList) {
        if (node == null)
            return;

        postOrderRecursiveHelper(node.left, ansList);
        postOrderRecursiveHelper(node.right, ansList);
        ansList.add(node);
    }

    public static ArrayList<TreeNode> preorderIterative(TreeNode root){
        ArrayList<TreeNode> ansList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            ansList.add(curr);

            // Push right child first so that left child is processed first
            if(curr.right != null){
                stack.push(curr.right);
            }
            if (curr.left != null){
                stack.push(curr.left);
            }

        }
        return ansList;
    }

    public static ArrayList<TreeNode> inorderIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        ArrayList<TreeNode> ansList = new ArrayList<>();

        while (!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                ansList.add(curr);
                curr = curr.right;
            }
        }
        return ansList;
    }

    public static ArrayList<TreeNode> postOrderIterative(TreeNode A) {
        TreeNode curr = A;
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        ArrayList<TreeNode> arr = new ArrayList<>();
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.peek();
                if (curr.right == null || curr.right == pre) {
                    arr.add(curr);
                    s.pop();
                    pre = curr;
                    curr = null;
                } else {
                    curr = curr.right;
                }
            }
        }
        return arr;
    }

    public static ArrayList<Integer> postOrderIterativeWith2Stacks(TreeNode root) {
        ArrayList<Integer> postOrder = new ArrayList<>();
        if (root == null) {
            return postOrder;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            postOrder.add(stack2.pop().val);
        }

        return postOrder;
    }

    public static ArrayList<TreeNode> postOrderIterativeUsingPreorder(TreeNode root){
        // lst rst rt ===reverse=> rt rst lst

        ArrayList<TreeNode> ansList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            ansList.add(curr);

            // Push left child first so that right child is processed first
            if(curr.left != null){
                stack.push(curr.left);
            }
            if (curr.right != null){
                stack.push(curr.right);
            }
        }

        Collections.reverse(ansList);
        return ansList;
    }

    public static TreeNode populateDepth(TreeNode root){
        preorderToPopulateDepth(root, -1);
        return root;
    }

    public static void preorderToPopulateDepth(TreeNode A, int parentDepth){
        if(A == null)
            return;

        A.depth = parentDepth+1;
        preorderToPopulateDepth(A.left, A.depth);
        preorderToPopulateDepth(A.right, A.depth);

    }

    public static TreeNode populateHeight(TreeNode root) {

        preorderToPopulateHeight(root);
        return root;
    }

    public static int preorderToPopulateHeight(TreeNode A){
        if(A == null)
            return -1;

        int height = Math.max(preorderToPopulateHeight(A.left), preorderToPopulateHeight(A.right)) + 1;

        A.height = height;
        return height;

    }

    // level order

    public static List<List<Integer>> levelOrderUsingMap(TreeNode root){
        List<List<Integer>> ansList = new ArrayList<>();
        HashMap<Integer, List<TreeNode>> mapOfNodesOnLevel = new HashMap<>();
        preorderForLevelPopulate(root, -1, mapOfNodesOnLevel);

        int max = mapOfNodesOnLevel.keySet().stream().reduce(Math::max).get();

        for(int i = 0; i <= max; i++){
            List<Integer> levelList = new ArrayList<>();
            for(TreeNode node: mapOfNodesOnLevel.get(i)){
                levelList.add(node.val);
            }
            ansList.add(levelList);
        }

        return ansList;
    }

    public static void preorderForLevelPopulate(TreeNode node, int parentLevel, HashMap<Integer, List<TreeNode>> map){
        if(node == null){
            return;
        }
        int nodeLevel = parentLevel+1;

        // root lst rst
        List<TreeNode> newList = new ArrayList<>();
        if(map.containsKey(nodeLevel)){
            newList.addAll(map.get(nodeLevel));
            newList.add(node);
        } else {
            newList.add(node);
        }
        map.put(nodeLevel, newList);

        preorderForLevelPopulate(node.left, nodeLevel, map);
        preorderForLevelPopulate(node.right, nodeLevel, map);


    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            // Enqueue left child
            if (current.left != null) {
                queue.add(current.left);
            }

            // Enqueue right child
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static List<List<Integer>> levelOrderUsingQueueAndPairClass(TreeNode root){
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));
        int currLevel = 0;

        List<Integer> currList = new ArrayList<>();

        while (!queue.isEmpty()){
            Pair top = queue.poll();

            if(top.level == currLevel){
                currList.add(top.node.val);
            } else {
                ansList.add(currList);
                currLevel = currLevel+1;
                currList = new ArrayList<>();
                currList.add(top.node.val);
            }

            if(top.node.left !=  null){
                queue.add(new Pair(top.node.left, top.level+1));
            }
            if(top.node.right !=  null){
                queue.add(new Pair(top.node.right, top.level+1));
            }
        }
        ansList.add(currList);

        return ansList;
    }

    static class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public static List<List<Integer>> levelOrderUsingDelimiter(TreeNode root){
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> currList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode top = queue.poll();

            if(queue.isEmpty() && top == null){
                break;
            }

            if(top == null){
                queue.add(null);
                ansList.add(currList);
                currList = new ArrayList<>();
                continue;
            } else {
                currList.add(top.val);
            }

            if(top.left != null){
                queue.add(top.left);
            }
            if(top.right != null){
                queue.add(top.right);
            }
        }

        ansList.add(currList);
        return ansList;
    }

    public static List<List<TreeNode>> levelOrderUsingDelimiterReturnTreenode(TreeNode root){
        List<List<TreeNode>> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<TreeNode> currList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode top = queue.poll();

            if(queue.isEmpty() && top == null){
                break;
            }

            if(top == null){
                queue.add(null);
                ansList.add(currList);
                currList = new ArrayList<>();
                continue;
            } else {
                currList.add(top);
            }

            if(top.left != null){
                queue.add(top.left);
            }
            if(top.right != null){
                queue.add(top.right);
            }
        }

        ansList.add(currList);
        return ansList;
    }

    // left and right view of tree using level order traversal
    // get level order and then for left view, pick 1st element from each level
    // get level order and then for right view, pick last element from each level

    public static List<Integer> leftViewOfTree(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> levelOrderMap = levelOrderUsingDelimiter(root);

        for(List<Integer> list : levelOrderMap){
            ans.add(list.getFirst());
        }

        return ans;
    }

    public static ArrayList<Integer> rightViewOfTree(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        List<List<Integer>> levelOrderMap = levelOrderUsingDelimiter(root);

        for(List<Integer> list : levelOrderMap){
            ans.add(list.getLast());
        }

        return ans;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrderMap = levelOrderUsingDelimiter(root);
        ArrayList<ArrayList<Integer>> zigzagOrder = new ArrayList<>();

        for(int i = 0; i<levelOrderMap.size(); i++){
            ArrayList<Integer> list = new ArrayList<>(levelOrderMap.get(i));
            if(i%2 == 1){
                Collections.reverse(list);
            }
            zigzagOrder.add(list);
        }
        return zigzagOrder;
    }

    public static int oddEvenLevel(TreeNode root) {
        List<List<Integer>> levelOrderMap = levelOrderUsingDelimiter(root);
        long evenSum = 0l;
        long oddSum = 0l;

        for(int i = 1; i<=levelOrderMap.size(); i++){
            ArrayList<Integer> list = new ArrayList<>(levelOrderMap.get(i-1));
            if(i%2 == 0){
                long sum = list.stream().reduce(0, Integer::sum);
                evenSum += (long) sum;
            } else {
                long sum = list.stream().reduce(0, Integer::sum);
                oddSum += (long) sum;
            }
        }

        return (int) Math.abs(evenSum-oddSum);
    }


    public static List<List<Integer>> verticalTraversalUsingMap(TreeNode root){
        List<List<Integer>> ansList = new ArrayList<>();
        HashMap<Integer, List<TreeNode>> mapForHDistance = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = root;
        //preorder
        preorderForHorizontalDistPopulate(root, 0, mapForHDistance);
        int max = mapForHDistance.keySet().stream().reduce(Math::max).get();
        int min = mapForHDistance.keySet().stream().reduce(Math::min).get();

        List<Integer> currList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            for(TreeNode node: mapForHDistance.get(i)){
                currList.add(node.val);
            }
            ansList.add(currList);
            currList = new ArrayList<>();
        }

        return ansList;
    }

    public static List<List<TreeNode>> verticalTraversalUsingMapReturnTreenode(TreeNode root){
        List<List<TreeNode>> ansList = new ArrayList<>();
        HashMap<Integer, List<TreeNode>> mapForHDistance = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = root;
        //preorder
        preorderForHorizontalDistPopulate(root, 0, mapForHDistance);
        int max = mapForHDistance.keySet().stream().reduce(Math::max).get();
        int min = mapForHDistance.keySet().stream().reduce(Math::min).get();

        List<TreeNode> currList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            for(TreeNode node: mapForHDistance.get(i)){
                currList.add(node);
            }
            ansList.add(currList);
            currList = new ArrayList<>();
        }

        return ansList;
    }

    public static void preorderForHorizontalDistPopulate(TreeNode node, int nodeLevel, HashMap<Integer, List<TreeNode>> map){
        if(node == null){
            return;
        }

        // root lst rst
        List<TreeNode> newList = new ArrayList<>();
        if(map.containsKey(nodeLevel)){
            newList.addAll(map.get(nodeLevel));
        }
        newList.add(node);
        map.put(nodeLevel, newList);

        preorderForHorizontalDistPopulate(node.left, nodeLevel-1, map);
        preorderForHorizontalDistPopulate(node.right, nodeLevel+1, map);
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        ArrayList<Integer> ar;

        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()){
            Pair top = queue.poll();
            TreeNode node = top.node;
            int hd = top.level;

            ar = new ArrayList<>();
            if(tm.containsKey(hd)){
                ar = tm.get(hd);
                ar.add(node.val);
            } else {
                ar.add(node.val);
            }
            tm.put(hd, ar);

            if(node.left != null){
                queue.add(new Pair(node.left, hd-1));
            }

            if(node.right != null){
                queue.add(new Pair(node.right, hd+1));
            }

        }
        for(int x: tm.keySet()){
            ArrayList<Integer> f = tm.get(x);
            ans.add(f);
        }

        return ans;

    }

    // top and bottom view of tree using vertical traversal
    public static List<Integer> topViewOfTree(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> verticalOrder = verticalTraversalUsingMap(root);

        for(List<Integer> list : verticalOrder){
            ans.add(list.getFirst());
        }
        return ans;
    }

    public static List<Integer> bottomViewOfTree(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> verticalOrder = verticalTraversalUsingMap(root);

        for(List<Integer> list : verticalOrder){
            ans.add(list.getLast());
        }
        return ans;
    }

    public static List<Integer> pathFromRootToK(TreeNode root){
        List<Integer> ansList = new ArrayList<>();
        KPresentInSubtree(root, 7, ansList);

        Collections.reverse(ansList);
        return ansList;
    }

    public static boolean KPresentInSubtree(TreeNode root, int k, List<Integer> ansList){
        if(root == null)
            return false;

        if(root.val == k){
            ansList.add(root.val);
            return true;
        }

        boolean isPresent = KPresentInSubtree(root.left, k, ansList) || KPresentInSubtree(root.right, k, ansList);

        if(isPresent){
            ansList.add(root.val);
            return true;
        }

        return false;
    }



}
