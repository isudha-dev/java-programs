package ProblemSolving.Trie;

import dsa.recursion.Factorial;

public class CrudOps {

    public static void main(String[] args) {
        TrieNode dummy = new TrieNode();
        CrudOps co = new CrudOps();
        co.add(dummy,"tarun");
        co.add(dummy, "tara");
        co.add(dummy, "keshav");
        co.add(dummy, "keshavi");
        co.add(dummy, "keshavani");
        co.add(dummy, "kesar");

        System.out.println(co.search(dummy, "keshav"));
        co.delete(dummy, "keshav");
        System.out.println(co.search(dummy, "keshavani"));
    }

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

    public void delete(TrieNode node, String s){
        TrieNode curr = node;
        for (Character c: s.toCharArray()){
            curr = curr.children[c-'a'];
            curr.count--;
        }
        if(curr.count > 0)
            curr.isEnd = false;

        if(curr.count == 0)
            curr.children = null;

    }

}
