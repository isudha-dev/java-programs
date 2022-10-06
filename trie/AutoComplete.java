package trie;

import java.util.ArrayList;
import java.util.Scanner;

public class AutoComplete {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tcs = scn.nextInt();
        scn.nextLine();
        for (int i = 0; i < tcs; i++) {
            int n = scn.nextInt();
            int m = scn.nextInt();
            scn.nextLine();

            ArrayList<String> dictionary = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                dictionary.add(scn.next());
            }
            scn.nextLine();

            ArrayList<Integer> weight = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                weight.add(scn.nextInt());
            }

            ArrayList<String> prefixes = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                prefixes.add(scn.next());
            }
        }
        scn.close();
    }

    public static void autoComplete(ArrayList<String> dictionary, ArrayList<Integer> weight,
            ArrayList<String> prefixes) {

    }

}
