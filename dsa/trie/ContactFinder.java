package dsa.trie;

import java.util.ArrayList;
import java.util.Arrays;

public class ContactFinder {

    public static void main(String[] args) {
        ContactFinder cf = new ContactFinder();
        cf.solve(new ArrayList<>(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 })),
                new ArrayList<>(Arrays.asList(new String[] { "s", "ss", "sss", "ssss", "sssss", "s", "ss", "sss",
                        "ssss", "sssss", "ssssss" })));
        // 5 4 3 2 1 0 act 5 5 5 5 5 0
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {

        TrieNode root = new TrieNode();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                insertTrie(root, B.get(i));
            }

            if (A.get(i) == 1) {
                ans.add(searchTrieReturnCount(root, B.get(i)));
            }
        }

        return ans;
    }

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
        int count;

        TrieNode() {
            // TrieNode node;
            for (int i = 0; i < 26; i++) {
                this.child[i] = null;
            }
            this.isEnd = false;
            this.count = 0;
        }
    }

    int searchTrieReturnCount(TrieNode root, String str) {
        TrieNode temp = root;
        int count = 0;
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            TrieNode child = temp.child[c[i] - 'a'];
            if (child == null)
                return 0;
            if (i == c.length - 1)
                count = child.count;
            temp = child;
        }
        return count;
    }

    void insertTrie(TrieNode root, String str) {
        TrieNode temp = root;
        for (Character c : str.toCharArray()) {
            if (temp.child[c - 'a'] == null)
                temp.child[c - 'a'] = new TrieNode();
            temp = temp.child[c - 'a'];
            temp.count++;
        }
        temp.isEnd = true;
        return;
    }

}
