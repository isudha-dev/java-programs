package ProblemSolving.Backtracking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problems {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, 1, 1)));
        A.add(new ArrayList<>(List.of(1, 0, 1)));
        A.add(new ArrayList<>(List.of(0, 0, 1)));
        System.out.println( ratInMaze(A));

//        ArrayList<ArrayList<Character>> a = new ArrayList<>();
//        a.add(new ArrayList<>(List.of('5','3','.','.','7','.','.','.','.')));
//        a.add(new ArrayList<>(List.of('6','.','.','1','9','5','.','.','.')));
//        a.add(new ArrayList<>(List.of('.','9','8','.','.','.','.','6','.')));
//        a.add(new ArrayList<>(List.of('8','.','.','.','6','.','.','.','3')));
//        a.add(new ArrayList<>(List.of('4','.','.','8','.','3','.','.','1')));
//        a.add(new ArrayList<>(List.of('7','.','.','.','2','.','.','.','6')));
//        a.add(new ArrayList<>(List.of('.','6','.','.','.','.','2','8','.')));
//        a.add(new ArrayList<>(List.of('.','.','.','4','1','9','.','.','5')));
//        a.add(new ArrayList<>(List.of('.','.','.','.','8','.','.','7','9')));
//
//        solveSudoku(a);
    }

    public static ArrayList<ArrayList<Integer>> ratInMaze(ArrayList<ArrayList<Integer>> A) {

        List<ArrayList<Integer>> ans = IntStream.range(0, A.size())
                .mapToObj(i -> new ArrayList<>(Collections.nCopies(A.size(), 0)))
                .collect(Collectors.toList());

        ratInMaze(0, 0, A, ans);
        return (ArrayList<ArrayList<Integer>>) ans;
    }

    public static boolean ratInMaze(int row, int col, ArrayList<ArrayList<Integer>> A, List<ArrayList<Integer>> ans) {
        if(row >= A.size() || col >= A.size() || A.get(row).get(col) == 0){
            return false;
        }

        if(row == A.size()-1 && col == A.size() - 1){
            ans.get(row).set(col, 1);
            return true;
        }

        ans.get(row).set(col, 1);
        boolean right = ratInMaze(row, col+1, A, ans);
        boolean down = ratInMaze(row+1, col, A, ans);

        if(right || down){
            return true;
        }

        ans.get(row).set(col, 0);
        return false;

    }


    public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
        ArrayList<HashSet<Character>> rowSet = new ArrayList<>();
        ArrayList<HashSet<Character>> colSet = new ArrayList<>();
        ArrayList<HashSet<Character>> boxSet = new ArrayList<>();

        HashSet<Character> set = new HashSet<>();
        //fill rows
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                Character ch = a.get(r).get(c);
                if(ch != '.')
                    set.add(ch);
            }
            rowSet.add(new HashSet<>(set));
            set.removeAll(set);
        }

        // fill cols
        for(int c = 0; c<9; c++){
            for (int r = 0; r < 9; r++) {
                Character ch = a.get(r).get(c);
                if(ch != '.')
                    set.add(ch);
            }
            colSet.add(new HashSet<>(set));
            set.removeAll(set);
        }

        // fill box
        int row = 0, col = 0;

        //for cols
        for (int i = 0; i < 3; i++) {
            // for rows
            for (int j = 0; j < 3; j++) {
                // for box
                for (int r = row; r < row+3; r++) {
                    for (int c = col; c < col + 3; c++) {
                        Character ch = a.get(r).get(c);
                        if(ch != '.')
                            set.add(ch);
                    }
                }
                boxSet.add(new HashSet<>(set));
                set.removeAll(set);
                col = col+3;
            }
            col = 0;
            row = row+3;
        }

        sudoku(0, 0, a, rowSet, colSet, boxSet);
        System.out.println(a);
    }

    public static boolean sudoku(int row, int col, ArrayList<ArrayList<Character>> a,
                                 ArrayList<HashSet<Character>> rowSet, ArrayList<HashSet<Character>> colSet, ArrayList<HashSet<Character>> boxSet){
        if(col == 9){
            row++;
            col = 0;
        }

        if(row == 9){
            return true;
        }

        Character ch = a.get(row).get(col);
        if(ch != '.'){
            return sudoku(row, col+1, a, rowSet, colSet, boxSet);
        }

        for(char c = '1'; c <= '9'; c++){
            int box = getBoxNum(row, col);
            if(!rowSet.get(row).contains(c) && !colSet.get(col).contains(c) && !boxSet.get(box).contains(c)){
                rowSet.get(row).add(c);
                colSet.get(col).add(c);
                boxSet.get(box).add(c);
                a.get(row).set(col, c);
                if(sudoku(row, col+1, a, rowSet, colSet, boxSet))
                    return true;

                a.get(row).set(col, '.');
                boxSet.get(box).remove(c);
                colSet.get(col).remove(c);
                rowSet.get(row).remove(c);
            }
        }

        return false;

    }

    public static int getBoxNum(int row, int col){
        if(row >=0 && row <3){
            if(col >=0 && col < 3){
                return 0;
            } else if (col >= 3 && col < 6){
                return 1;
            } else {
                return 2;
            }
        } else if(row >=3 && row <6){
            if(col >=0 && col < 3){
                return 3;
            } else if (col >= 3 && col < 6){
                return 4;
            } else {
                return 5;
            }
        } else {
            if(col >=0 && col < 3){
                return 6;
            } else if (col >= 3 && col < 6){
                return 7;
            } else {
                return 8;
            }
        }
    }


    public static ArrayList<ArrayList<String>> nQueens(int A) {
        HashSet<Integer> colsHs = new HashSet<>();
        HashSet<Integer> lrDiagHs = new HashSet<>();
        HashSet<Integer> rlDiagHs = new HashSet<>();

        int[][] board = new int[A][];
        for (int i = 0; i < A ; i++) {
            board[i] = new int[A];
        }

        nQueensRecur(0, A, board, colsHs, lrDiagHs, rlDiagHs);



        return null;
    }

    static void nQueensRecur(int row, int A, int[][] board, HashSet<Integer> colsHs, HashSet<Integer> lrDiagHs, HashSet<Integer> rlDiagHs){
        if(row == A){
            //print board
            return;
        }

        for(int col = 0; col < A; col++){
            if(!colsHs.contains(col) && !lrDiagHs.contains(row-col) && !rlDiagHs.contains(row+col)){

                // do
                colsHs.add(col);
                lrDiagHs.add(row-col);
                rlDiagHs.add(row+col);
                board[row][col] = 1;
                nQueensRecur(row+1, A, board, colsHs, lrDiagHs, rlDiagHs);

                // undo
                board[row][col] = 0;
                colsHs.remove(col);
                lrDiagHs.remove(row-col);
                rlDiagHs.remove(row+col);
            }
        }

    }



    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<Integer> temp = new ArrayList<>(Collections.nCopies(A.size(), -1));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generatePermutation(0, A, temp, ans);
        return ans;
    }

    public static void generatePermutation(int idx, ArrayList<Integer> A, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans){
        if(idx == A.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < A.size(); i++) {
            if(temp.get(i) == -1){
                temp.set(i, A.get(idx));
                generatePermutation(idx+1, A, temp, ans);
                temp.set(i, -1);
            }
        }
    }

    public static int sixlets(ArrayList<Integer> A, int B) {
        int ans = countSumMoreThan1000(0, A, B, 0, 0);
        return ans;
    }

    public static int countSumMoreThan1000(int idx, ArrayList<Integer> A, int B, int sum, int size){
        if(size == B){
            if(sum <= 1000){
                return 1;
            } else {
                return 0;
            }
        }

        if(sum > 1000 || idx == A.size()){
            return 0;
        }

        // choose
        int num = A.get(idx);
        sum += num;
        size++;
        int x = countSumMoreThan1000(idx+1, A, B, sum, size);
        size--;
        sum -= num;

        // dont choose
        int y = countSumMoreThan1000(idx+1, A, B, sum, size);

        return x+y;
    }

    public static ArrayList<ArrayList<Integer>> subsetsInLexicographicalOrder(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        getSubsets(0, new ArrayList<>(), A.size(), A, ans);

        Collections.sort(ans, (o1, o2) -> {
            int minSize = Math.min(o1.size(), o2.size());
            for (int i = 0; i < minSize; i++) {
                if (o1.get(i) < o2.get(i)) {
                    return o1.get(i).compareTo(o2.get(i));
                }
            }
            return o1.size() <= o2.size() ? -1 : 1;
        });


        return ans;
    }

    public static void getSubsets(int idx, ArrayList<Integer> subset, int size, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans){
        if(idx == size){
            ans.add(new ArrayList<>(subset));
            return;
        }

        // dont choose idx
        getSubsets(idx+1, subset, size, A, ans);

        // choose idx
        subset.add(A.get(idx));
        getSubsets(idx+1, subset, size, A, ans);
        subset.remove(A.get(idx));
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        A = (ArrayList<Integer>) A.stream().distinct().collect(Collectors.toList());
        generateSum(0, A, B, new ArrayList<>(), ans);

        Collections.sort(ans, (o1, o2) -> {
            int min = Math.min(o1.size(), o2.size());
            for (int i = 0; i < min; i++) {
                if(o1.get(i) != o2.get(i))
                    return o1.get(i).compareTo(o2.get(i));
            }

            return o1.size() <= o2.size() ? -1: 1;
        });
        return ans;
    }

    public static void generateSum(int idx, ArrayList<Integer> A, int B, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans){
        if(B < 0){
            return;
        }
        if(B == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx; i<A.size(); i++){
            int currElem = A.get(i);

            temp.add(currElem);
            generateSum(i, A, B-currElem, temp, ans);
            temp.remove(temp.size()-1);
        }
    }

}
