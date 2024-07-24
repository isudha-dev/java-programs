package ProblemSolving.Trie;

public class CrudOps {

    public TrieNode add(TrieNode node, String s){
        TrieNode curr = node;
        for (Character c: s.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
            curr.count++;
        }
        curr.isEnd = true;
        return node;
    }


    public boolean search(TrieNode node, String s) {
        TrieNode curr = node;
        for(Character c: s.toCharArray()){
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

}
