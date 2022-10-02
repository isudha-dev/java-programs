package trie;

public class SpellingChecker {

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
            this.count = 1;
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

    public int[] solve(String[] A, String[] B) {
        // insert into trie
        TrieNode root = new TrieNode();
        for (String s : A) {
            insertTrie(root, s);
        }
        int[] ans = new int[B.length];
        int idx = 0;

        // search in trie
        for (String s : B) {
            ans[idx] = searchTrie(root, s) ? 1 : 0;
            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        SpellingChecker sp = new SpellingChecker();
        sp.solve(new String[] { "hat", "cat", "rat" }, new String[] { "cat", "ball" });
    }

}
