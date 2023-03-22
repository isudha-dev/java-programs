package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Sudoku {

    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        ArrayList<ArrayList<Character>> arr = new ArrayList<>();

        ArrayList<Character> arrCh = new ArrayList<>(
                Arrays.asList(new Character[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' }));
        arr.add(new ArrayList<>(arrCh));

        arrCh = new ArrayList<>(
                Arrays.asList(new Character[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' }));
        arr.add(new ArrayList<>(arrCh));

        arrCh = new ArrayList<>(
                Arrays.asList(new Character[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' }));
        arr.add(new ArrayList<>(arrCh));

        arrCh = new ArrayList<>(
                Arrays.asList(new Character[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' }));
        arr.add(new ArrayList<>(arrCh));

        arrCh = new ArrayList<>(
                Arrays.asList(new Character[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' }));
        arr.add(new ArrayList<>(arrCh));

        arrCh = new ArrayList<>(
                Arrays.asList(new Character[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' }));
        arr.add(new ArrayList<>(arrCh));

        arrCh = new ArrayList<>(
                Arrays.asList(new Character[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' }));
        arr.add(new ArrayList<>(arrCh));

        arrCh = new ArrayList<>(
                Arrays.asList(new Character[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' }));
        arr.add(new ArrayList<>(arrCh));

        arrCh = new ArrayList<>(
                Arrays.asList(new Character[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' }));
        arr.add(new ArrayList<>(arrCh));

        s.solveSudoku(arr);
    }

    ArrayList<HashSet<Character>> rSet = new ArrayList<>();
    ArrayList<HashSet<Character>> cSet = new ArrayList<>();
    ArrayList<HashSet<Character>> boxSet = new ArrayList<>();

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        HashSet<Character> set = new HashSet<>();

        // adding elements to rSet
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Character ch = a.get(row).get(col);
                if (!ch.equals('.'))
                    set.add(a.get(row).get(col));
            }
            rSet.add(new HashSet<>(set));
            set.removeAll(set);
        }

        // adding elements to cSet
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                Character ch = a.get(row).get(col);
                if (!ch.equals('.'))
                    set.add(a.get(row).get(col));
            }
            cSet.add(new HashSet<>(set));
            set.removeAll(set);
        }

        // adding elements to boxSet
        int row = 0, col = 0;
        int count1 = 0, count2 = 0;
        while (count1 < 3) { // for iterating on rows
            count2 = 0;
            col = 0;
            while (count2 < 3) { // for iterating on cols
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        Character ch = a.get(i).get(j);
                        if (!ch.equals('.'))
                            set.add(a.get(i).get(j));
                    }
                }
                boxSet.add(new HashSet<>(set));
                set.removeAll(set);
                col = col + 3;
                count2++;
            }
            row = row + 3;
            count1++;
        }

        sudoku(a, 0, 0);
        return;

    }

    public boolean sudoku(ArrayList<ArrayList<Character>> a, int row, int col) {

        if (col == 9) {
            row++;
            col = 0;
        }
        if (row == 9) {
            return true;
        }

        if (a.get(row).get(col) != '.') {
            return sudoku(a, row, col + 1);
        }

        for (char c = '1'; c <= '9'; c++) {
            int box = getBoxNum(row, col);
            if (!rSet.get(row).contains(c) && !cSet.get(col).contains(c) && !boxSet.get(box).contains(c)) {
                // Do
                rSet.get(row).add(c);
                cSet.get(col).add(c);
                boxSet.get(box).add(c);
                a.get(row).set(col, c);
                if (sudoku(a, row, col + 1))
                    return true;
                // Undo
                a.get(row).set(col, '.');
                rSet.get(row).remove(c);
                cSet.get(col).remove(c);
                boxSet.get(box).remove(c);
            }
        }
        return false;

    }

    public int getBoxNum(int row, int col) {
        if (row >= 0 && row <= 2) {
            if (col >= 0 && col <= 2) {
                return 0;
            } else if (col >= 3 && col <= 5) {
                return 1;
            } else {
                return 2;
            }
        } else if (row >= 3 && row <= 5) {
            if (col >= 0 && col <= 2) {
                return 3;
            } else if (col >= 3 && col <= 5) {
                return 4;
            } else {
                return 5;
            }
        } else {
            if (col >= 0 && col <= 2) {
                return 6;
            } else if (col >= 3 && col <= 5) {
                return 7;
            } else {
                return 8;
            }
        }
    }

}
