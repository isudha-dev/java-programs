package hashing;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// https://www.scaler.com/academy/mentee-dashboard/class/35249/assignment/problems/4759?navref=cl_tt_nv
public class CountRectangle {

    static class Coordinate {

        int x_cord;
        int y_cord;

        Coordinate(int x_cord, int y_cord) {
            this.x_cord = x_cord;
            this.y_cord = y_cord;
        }

        @Override
        public int hashCode() {
            return x_cord * 31 + y_cord;
        }

        @Override
        public boolean equals(Object obj) {
            Coordinate co = (Coordinate) obj;
            return (co.x_cord == this.x_cord && co.y_cord == this.y_cord);
        }
    }

    // solution with unordered set - TC: O(N^2)
    public static int solve1(int[] A, int[] B) {
        HashSet<Coordinate> cordSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            cordSet.add(new Coordinate(A[i], B[i]));
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] != A[j] && B[i] != B[j]) {
                    Coordinate c1 = new Coordinate(A[i], B[j]);
                    Coordinate c2 = new Coordinate(A[j], B[i]);
                    if (cordSet.contains(c1) && cordSet.contains(c2)) {
                        count++;
                    }
                }
            }
        }

        return count / 2;
    }

    static class Pair<X, Y> {

        X x;
        Y y;

        Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public X getKey() {
            return x;
        }

        public Y getValue() {
            return y;
        }
    }

    // solution with ordered set - TC: O(N^2 * Log N)
    public static int solve2(int[] A, int[] B) {
        Set<Pair<Integer, Integer>> cordSet = new TreeSet<>((obj1, obj2) -> {
            int x1 = obj1.getKey();
            int y1 = obj1.getValue();
            int x2 = obj2.getKey();
            int y2 = obj1.getValue();
            return Integer.compare(x1 * 31 + y1, x2 * 31 + y2);
        });

        for (int i = 0; i < A.length; i++) {
            cordSet.add(new Pair<>(A[i], B[i]));
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] != A[j] && B[i] != B[j]) {
                    Pair<Integer, Integer> p1 = new Pair<>(A[i], B[j]);
                    Pair<Integer, Integer> p2 = new Pair<>(A[j], B[i]);
                    if (cordSet.contains(p1) && cordSet.contains(p2)) {
                        count++;
                    }
                }
            }
        }

        return count / 2;
    }

    public static void main(String[] args) {
        System.out.println(solve1(new int[] { 1, 1, 2, 2, 3, 3 }, new int[] { 1, 2, 1, 2, 1, 2 }));
        System.out.println(solve2(new int[] { 1, 1, 2, 2, 3, 3 }, new int[] { 1, 2, 1, 2, 1, 2 }));
    }

}
