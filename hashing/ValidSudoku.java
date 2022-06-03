package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {

    public static void main(String[] args) {
        String[] str = new String[] { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6",
                ".6....28.", "...419..5", "....8..79" };

        List<String> A = new ArrayList<>(Arrays.asList(str));
        System.out.println(isValidSudoku(A));

    }

    static int isValidSudoku(final List<String> A) {

        HashSet<Character> hs = new HashSet<>();

        // validating rows
        for (int i = 0; i < A.size(); i++) {
            char[] ch = A.get(i).toCharArray();
            for (char c : ch) {
                if (c != '.') {
                    if (hs.contains(c)) {
                        return 0;
                    }
                    hs.add(c);
                }
            }
            hs.clear();
        }

        // validating cols
        for (int i = 0; i < A.size(); i++) {
            int idx = 0;
            while (idx < A.size()) {
                char c = A.get(idx).charAt(i);
                if (c != '.') {
                    if (hs.contains(c)) {
                        return 0;
                    }
                    hs.add(c);
                }
                idx++;
            }
            hs.clear();
        }

        // validating box
        int boxSize = A.size() / 3;
        int start = 0;
        int end = 2;
        for (int i = 0; i < boxSize; i++) {
            int j = 0;
            while (j < A.size()) {
                for (int k = start; k <= end; k++) {
                    char c = A.get(j).charAt(k);
                    if (c != '.') {
                        if (hs.contains(c)) {
                            return 0;
                        }
                        hs.add(c);
                    }
                }
                if ((j + 1) % boxSize == 0 && j != 0) {
                    hs.clear();
                }
                j++;
            }
            start = start + boxSize;
            end = end + boxSize;

        }

        return 1;
    }

}
