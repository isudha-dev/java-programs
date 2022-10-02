package trie;

public class ShortestUniquePrefix {
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

    String searchTrie(TrieNode root, String str) {
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();
        for (Character c : str.toCharArray()) {
            if (temp.child[c - 'a'] == null)
                return "Invalid input";
            sb.append(c);
            if (temp.child[c - 'a'].count == 1) {
                return sb.toString();
            }
            temp = temp.child[c - 'a'];
        }
        return "Invalid input";
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

    public String[] prefix(String[] A) {
        TrieNode root = new TrieNode();
        for (String s : A) {
            insertTrie(root, s);
        }
        String[] ans = new String[A.length];
        int idx = 0;
        for (String s : A) {
            ans[idx] = searchTrie(root, s);
            idx++;
        }

        return ans;
    }

    public static void main(String[] args) {
        ShortestUniquePrefix sup = new ShortestUniquePrefix();
        sup.prefix(new String[] { "zebra", "dog", "duck", "dove" });
    }

}
