package trie;

import java.util.HashMap;

public class ModifiedSearch {

    public static void main(String[] args) {
        ModifiedSearch ms = new ModifiedSearch();
        String ans = ms.solve(new String[] { "data", "circle", "cricket" },
                new String[] { "date", "circel", "crikket", "data", "circl" });
        System.out.println(ans);
    }

    public String solve(String[] A, String[] B) {
        TrieNode root = new TrieNode();
        for (String s : A) {
            insertTrie(root, s);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : B) {
            sb.append((modifiedSearch(root, 0, s, false)) ? 1 : 0);
        }
        return sb.toString();
    }

    class TrieNode {
        HashMap<Character, TrieNode> child;
        boolean isEnd;

        TrieNode() {
            child = new HashMap<>();
            isEnd = false;
        }
    }

    public void insertTrie(TrieNode root, String str) {
        TrieNode curr = root;
        for (Character c : str.toCharArray()) {
            if (!curr.child.containsKey(c)) {
                curr.child.put(c, new TrieNode());
            }
            curr = curr.child.get(c);
        }
        curr.isEnd = true;
    }

    public boolean modifiedSearch(TrieNode root, int idx, String str, boolean isModified) {
        int n = str.length();
        TrieNode curr = root;
        if (idx == n && isModified && curr.isEnd)
            return true;

        if (idx >= n)
            return false;

        char letter = str.charAt(idx);
        if (isModified) {
            if (curr.child.containsKey(letter))
                return modifiedSearch(curr.child.get(letter), idx + 1, str, isModified);

        } else {
            for (char c : curr.child.keySet()) {
                if (c == letter) {
                    if (modifiedSearch(curr.child.get(c), idx + 1, str, isModified))
                        return true;
                } else {
                    if (modifiedSearch(curr.child.get(c), idx + 1, str, true))
                        return true;
                }
            }
        }

        return false;
    }

}
