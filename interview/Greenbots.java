package interview;

import java.util.ArrayList;
import java.util.HashSet;

public class Greenbots {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode tempRoot = root.left;
        tempRoot.left = new TreeNode(4);
        tempRoot.right = new TreeNode(5);

        tempRoot = root.right;
        tempRoot.right = new TreeNode(6);

        ArrayList<String> arrayList = new ArrayList<>();
        rootToLeaf(root, root.val+"", arrayList);

        ArrayList<Integer> intArr = new ArrayList<>();
        for(String str: arrayList){
            intArr.add(Integer.parseInt(str));
        }
        int sum = 0;
        for(Integer i: intArr){
            sum += i;
        }

        System.out.println(sum);

//        consecutiveNums(new int[] {1002, 94, 93, 1000, 1003, 92, 1001, 1004, 91});
        // 92, 93, 94 - 92
        // 1000, 1001, 1002
     }

    static void consecutiveNums(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> intArr = new ArrayList<>();
        int lowestNum = Integer.MAX_VALUE;

        for(int i: arr){
            set.add(i);
        }

        for(int i: arr){
            if(set.contains(i+1)){
                continue;
            }
            if(!set.contains(i-1)){
                continue;
            }
            int temp = i;
            while (set.contains(temp)){
                lowestNum = Math.min(temp, lowestNum);
                temp--;
            }

        }

        System.out.println(lowestNum);
        while (set.contains(lowestNum)){
            intArr.add(lowestNum++);
        }


        intArr.forEach(System.out::println);

    }

    static void rootToLeaf(TreeNode root, String str, ArrayList<String> arrayList){
        if(root.left == null && root.right == null){
            System.out.println(str);
            arrayList.add(str);
        }

        if(root.left != null){
            rootToLeaf(root.left, str+root.left.val, arrayList);
        }

        if(root.right != null){
            rootToLeaf(root.right, str+root.right.val, arrayList);
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }
}
