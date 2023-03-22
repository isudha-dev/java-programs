package dsa.trie;

import java.util.ArrayList;
import java.util.Arrays;

public class MapSumPairs {

    public static void main(String[] args) {
        MapSumPairs msp = new MapSumPairs();
        msp.solve(new ArrayList<>(Arrays.asList(new String[] { "ban", "banana", "ba" })),
                new ArrayList<>(Arrays.asList(new Integer[] { 10, -1, -1 })));
    }

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<Integer> B) {

        TrieNode root = new TrieNode('/');
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (B.get(i) != -1) {
                // type 1 op
                insertTrie(root, A.get(i), B.get(i));

            } else {
                // type 2 op
                res.add(searchTrie(root, A.get(i)));
            }
        }
        return res;
    }

    class TrieNode {
        TrieNode[] child;
        boolean isEnd;
        int count;
        char data;
        int val;

        TrieNode(char data) {
            // TrieNode node;
            child = new TrieNode[26];
            this.isEnd = false;
            this.count = 0;
            this.data = data;
            this.val = -1;
        }
    }

    int searchTrie(TrieNode root, String str) {
        TrieNode temp = root;
        for (Character c : str.toCharArray()) {
            TrieNode child = temp.child[c - 'a'];
            if (child == null)
                return 0;
            temp = child;
        }
        int sum = 0;
        sum = sumOfValidWordValue(temp, sum);
        return sum;
    }

    int sumOfValidWordValue(TrieNode root, int sum) {
        if (root == null) {
            return sum;
        }
        if (root.val != -1) {
            sum += root.val;
        }
        for (TrieNode child : root.child) {
            if (child != null)
                sum = sumOfValidWordValue(child, sum);
        }
        return sum;
    }

    void insertTrie(TrieNode root, String str, int val) {
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();
        for (Character c : str.toCharArray()) {
            sb.append(c);
            if (temp.child[c - 'a'] == null) {
                temp.child[c - 'a'] = new TrieNode(c);
            }
            temp = temp.child[c - 'a'];
            temp.count++;
        }
        temp.isEnd = true;
        temp.val = val;
    }

}
