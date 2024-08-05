package ProblemSolving.Trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Trie node
    class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // Assuming only lowercase English letters
            isEndOfWord = false;
        }
    }

    // Insert a key into the Trie
    public void insert(String key) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Search for a key in the Trie
    public boolean search(String key) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    // Delete a key from the Trie
    public boolean delete(String key) {
        return delete(root, key, 0);
    }

    private boolean delete(TrieNode current, String key, int depth) {
        if (current == null) {
            return false;
        }

        // If the last character of the key is being processed
        if (depth == key.length()) {
            // This node is no longer the end of a word
            if (current.isEndOfWord) {
                current.isEndOfWord = false;
            }

            // If the current node has no children, it can be deleted
            return current.children.length == 0;
        }

        int index = key.charAt(depth) - 'a';
        TrieNode node = current.children[index];

        if (node == null) {
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(node, key, depth + 1);

        // If true, delete the node mapping to the character index
        if (shouldDeleteCurrentNode) {
            current.children[index] = null;

            // Return true if no children are left in the current node and it is not end of another word
            return current.isEndOfWord == false && hasNoChildren(current);
        }

        return false;
    }

    // Helper method to check if a node has no children
    private boolean hasNoChildren(TrieNode node) {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");

        System.out.println("Search 'hello': " + trie.search("hello")); // true
        System.out.println("Search 'world': " + trie.search("world")); // true
        System.out.println("Search 'hell': " + trie.search("hell"));   // false

        trie.delete("hello");
        System.out.println("Search 'hello' after deletion: " + trie.search("hello")); // false
        System.out.println("Search 'world': " + trie.search("world")); // true
    }
}

