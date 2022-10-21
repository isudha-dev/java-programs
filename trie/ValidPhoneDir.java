package trie;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidPhoneDir {

    public static void main(String[] args) {
        ValidPhoneDir vp = new ValidPhoneDir();
        vp.solve(new ArrayList<>(Arrays.asList(new String[] { "740948824551", "1152761423221685761892795431", "334",
                "1387427793198650286024", "65090061389344606618496378829", "33" })));
    }

    public int solve(ArrayList<String> A) {

        TrieNode root = new TrieNode();
        for (String s : A) {
            boolean ans = insertTrie(root, s);
            if (ans == false)
                return 0;
        }

        return 1;
    }

    class TrieNode {
        TrieNode[] child = new TrieNode[10];
        boolean isEnd;
        int count;

        TrieNode() {
            // TrieNode node;
            for (int i = 0; i < 10; i++) {
                this.child[i] = null;
            }
            this.isEnd = false;
            this.count = 0;
        }
    }

    boolean insertTrie(TrieNode root, String str) {
        TrieNode temp = root;
        // insert in trie
        for (Character c : str.toCharArray()) {
            if (temp.child[c - 48] == null)
                temp.child[c - 48] = new TrieNode();
            temp = temp.child[c - 48];
            temp.count++;
        }
        temp.isEnd = true;

        // search in trie
        temp = root;
        for (Character c : str.toCharArray()) {
            if (temp.child[c - 48] == null)
                return true;
            temp = temp.child[c - 48];
        }
        return temp.count > 1 ? false : true;

    }

}
