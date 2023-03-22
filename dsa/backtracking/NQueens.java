package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class NQueens {

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        nq.solveNQueens(4);
    }

    HashSet<Integer> cSet = new HashSet<>();
    HashSet<Integer> l2rDiag = new HashSet<>();
    HashSet<Integer> r2lDiag = new HashSet<>();

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> board = new ArrayList<>();
        nQueens(0, A, new ArrayList<String>(), board);
        return board;
    }

    void nQueens(int row, int N, ArrayList<String> postions, ArrayList<ArrayList<String>> board) {

        if (row == N) {
            board.add(new ArrayList<>(postions));
            return;
        }

        char[] ch = new char[N];
        Arrays.fill(ch, '.');
        for (int col = 0; col < N; col++) {
            if (!cSet.contains(col) && !l2rDiag.contains(row - col) && !r2lDiag.contains(row + col)) {
                ch[col] = 'Q';
                cSet.add(col);
                l2rDiag.add(row - col);
                r2lDiag.add(row + col);
                String temp = new String(ch);
                postions.add(temp);
                nQueens(row + 1, N, postions, board);
                ch[col] = '.';
                postions.remove(temp);
                cSet.remove(col);
                l2rDiag.remove(row - col);
                r2lDiag.remove(row + col);
            }
        }
    }

}
