package ProblemSolving.Trie;

public class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    int count;

    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
        count = 0;
    }

}
