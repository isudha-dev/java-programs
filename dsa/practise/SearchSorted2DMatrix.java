package dsa.practise;

// https://leetcode.com/problems/search-a-2d-matrix/
public class SearchSorted2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int currRow = 0;

        for(int r = currRow; r < rows; r++){
            if(target == matrix[r][cols - 1]){
                return true;
            } else if(target < matrix[r][cols - 1]){
                if(target < matrix[r][0]){
                    return false;
                }
                return binarySearch(matrix[r], target);
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] row, int target){
        int p1 = 0;
        int p2 = row.length - 1;

        while (p1 <= p2){
            int mid = (p1 + p2) /2;
            if(row[mid] == target){
                return true;
            } else if(target < row[mid]){
                p2 = mid - 1;
            } else {
                p1 = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5}};
        System.out.println(searchMatrix(matrix, 1));
    }

}
