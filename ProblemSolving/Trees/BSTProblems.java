package ProblemSolving.Trees;

import java.util.ArrayList;
import java.util.List;

public class BSTProblems {
    public static void main(String[] args) {
        // 20 14 12 11 -1 -1 -1 -1 -1
//        TreeNode A = new TreeNode(9);
//        A.left = new TreeNode(10);
//        A.right = new TreeNode(6);
//
//        TreeNode temp = A.left;
//        temp.left = new TreeNode(3);
//        temp.right = new TreeNode(18);

//        TreeNode temp2 = A.right;
//        temp2.left = new TreeNode(30);
//        temp2.right = new TreeNode(21);

//        TreeNode temp3 = temp.left;
//        temp3.left = new TreeNode(9);
//        temp3.right = new TreeNode(21);

        System.out.println(bstWithOneChild(new ArrayList<>(List.of(4, 10, 5, 8))));
    }

    public static String bstWithOneChild(ArrayList<Integer> A) {
        int minL = Integer.MIN_VALUE;
        int maxL = A.get(0)-1;
        int minR = A.get(0)+1;
        int maxR = Integer.MAX_VALUE;

        for(int i = 1; i< A.size(); i++){

            if(A.get(i) > minL && A.get(i) < maxL){
                maxR = maxL;
                maxL = A.get(i)-1;
                minR = A.get(i)+1;
            } else if (A.get(i) > minR && A.get(i) < maxR){
                minL = minR;
                maxL = A.get(i)-1;
                minR = A.get(i)+1;
            } else {
                return "NO";
            }
        }

        return "YES";
    }

    public static TreeNode sortedArrayToBST(final int[] A) {
        return sortedArrayToBSTHelper(A, 0, A.length-1);
    }

    public static TreeNode sortedArrayToBSTHelper(int[] A, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(A[mid]);

        root.left = sortedArrayToBSTHelper(A, start, mid-1);
        root.right = sortedArrayToBSTHelper(A, mid+1, end);

        return root;
    }

    public static int isValidBST(TreeNode A) {
        return isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    public static boolean isValidBST(TreeNode A, int min, int max){
        if(A == null){
            return true;
        }

        if (A.val < min || A.val > max) {
            return false;
        }
        boolean left = isValidBST(A.left, min, A.val-1);
        boolean right = isValidBST(A.right, A.val+1, max);

        return left && right;
    }
}
