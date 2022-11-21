package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class AutoComplete {

    public static void main(String[] args) {
        ArrayList<String> dictionary = new ArrayList<>(
                Arrays.asList(new String[] { "abcd", "aecd", "abaa", "abef", "acdcc", "acbcc"
                }));
        ArrayList<Integer> weight = new ArrayList<>(Arrays.asList(new Integer[] { 2,
                1, 3, 4, 6, 5 }));
        ArrayList<String> prefixes = new ArrayList<>(Arrays.asList(new String[] {
                "ab", "abc", "a", "abd" }));

        AutoComplete ac = new AutoComplete();
        ac.autoComplete(dictionary, weight, prefixes);

        // AutoComplete ac = new AutoComplete();
        ac.perform();

    }

    public void perform() {
        Scanner scn = new Scanner(System.in);
        int tcs = scn.nextInt();
        scn.nextLine();
        ArrayList<ArrayList<ArrayList<String>>> finalList = new ArrayList<>();
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

            ArrayList<ArrayList<String>> ans = autoComplete(dictionary, weight, prefixes);
            finalList.add(ans);

        }
        showOutput(finalList);
        scn.close();
    }

    public static void showOutput(ArrayList<ArrayList<ArrayList<String>>> finalList) {
        for (ArrayList<ArrayList<String>> list : finalList) {
            for (ArrayList<String> str : list) {
                for (String s : str) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

    public ArrayList<ArrayList<String>> autoComplete(ArrayList<String> dictionary, ArrayList<Integer> weight,
            ArrayList<String> prefixes) {

        TreeMap<Integer, String> tMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < dictionary.size(); i++) {
            tMap.put(weight.get(i), dictionary.get(i));
        }

        TrieNode root = new TrieNode();
        for (Entry<Integer, String> entry : tMap.entrySet()) {
            insertTrie(root, entry.getKey(), entry.getValue());
        }

        ArrayList<ArrayList<Integer>> ansTemp = new ArrayList<>();
        for (String pref : prefixes) {
            ArrayList<Integer> list = searchPrefix(root, pref);
            ansTemp.add(list);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (ArrayList<Integer> temp : ansTemp) {
            ArrayList<String> list = new ArrayList<>();
            if (temp.size() == 0) {
                list.add("-1");
            } else {
                for (Integer i : temp) {
                    list.add(tMap.get(i));
                }
            }
            ans.add(list);
        }

        return ans;

    }

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
        int count;
        ArrayList<Integer> wordIdx;

        TrieNode() {
            // TrieNode node;
            for (int i = 0; i < 26; i++) {
                this.child[i] = null;
            }
            this.isEnd = false;
            this.count = 0;

            wordIdx = new ArrayList<>();
        }
    }

    boolean searchTrie(TrieNode root, String str) {
        TrieNode temp = root;
        // for (TrieNode child : root.child) {

        // }
        for (Character c : str.toCharArray()) {
            if (temp.child[c - 'a'] == null)
                return false;
            temp = temp.child[c - 'a'];
        }
        return temp.isEnd;
    }

    ArrayList<Integer> searchPrefix(TrieNode root, String pref) {
        TrieNode temp = root;
        for (Character c : pref.toCharArray()) {
            if (temp.child[c - 'a'] == null)
                return new ArrayList<>();
            temp = temp.child[c - 'a'];
        }
        return temp.wordIdx;
    }

    void insertTrie(TrieNode root, int idx, String str) {
        TrieNode temp = root;
        for (Character c : str.toCharArray()) {
            if (temp.child[c - 'a'] == null)
                temp.child[c - 'a'] = new TrieNode();
            if (temp.child[c - 'a'].wordIdx.size() != 5)
                temp.child[c - 'a'].wordIdx.add(idx);
            temp = temp.child[c - 'a'];
            temp.count++;
        }
        temp.isEnd = true;
        return;
    }

}
