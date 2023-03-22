package dsa.trie;

public class BasicTrieOps {

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

    boolean searchTrie(TrieNode root, String str) {
        TrieNode temp = root;
        for (Character c : str.toCharArray()) {
            if (temp.child[c - 'a'] == null)
                return false;
            temp = temp.child[c - 'a'];
        }
        return temp.isEnd;
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
