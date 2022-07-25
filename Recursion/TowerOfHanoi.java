package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        toh(3, 1, 2, 3, ans);
        System.out.println(ans);
    }

    static void toh(int n, char source, char temp, char destination) {
        if (n == 0)
            return;
        toh(n - 1, source, destination, temp);
        System.out.println("From " + source + "->" + destination);
        toh(n - 1, temp, source, destination);
    }

    static void toh(int n, int source, int temp, int destination, ArrayList<ArrayList<Integer>> ans) {
        if (n == 0)
            return;
        toh(n - 1, source, destination, temp, ans);
        // System.out.println("From " + s + "->" + d);
        ans.add(new ArrayList<>(new ArrayList<>(Arrays.asList(new Integer[] { n, source, destination }))));

        toh(n - 1, temp, source, destination, ans);
    }

}
