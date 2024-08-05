package interview.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// implement search from given list of dictionary. You will be given prefix for search.

public class AutoComplete {

    TrieNode root;

    AutoComplete(){
        root = new TrieNode();
    }
    void addWords(List<String> allWords){
        for(String str: allWords){
            TrieNode temp = root;
            for(Character c: str.toCharArray()){
                if(! temp.childrenMap.containsKey(c)){
                    temp.childrenMap.put(c, new TrieNode());
                }
                temp = temp.childrenMap.get(c);
            }
            temp.isEnd = true;
        }
    }

    List<String> getPredictions(String prefix){
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();

        for(Character c: prefix.toCharArray()){
            if(!temp.childrenMap.containsKey(c)){
                return new ArrayList<>();
            } else {
                sb.append(c);
                temp = temp.childrenMap.get(c);
            }
        }

        List<String> ansList = new ArrayList<>();
        traversal(temp, sb, ansList);

        return ansList;
    }

    void traversal(TrieNode root, StringBuilder sb, List<String> ansList){
        if(root.isEnd){
            ansList.add(sb.toString());
        }

        if(root.childrenMap.isEmpty()){
            return;
        }

        for (Map.Entry<Character, TrieNode> entryNode: root.childrenMap.entrySet()){
            sb.append(entryNode.getKey());
            traversal(entryNode.getValue(), sb, ansList);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    static class TrieNode {
        HashMap<Character, TrieNode> childrenMap;
        boolean isEnd;

        TrieNode(){
            childrenMap = new HashMap<>();
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        AutoComplete ac = new AutoComplete();
        List<String> allWords = new ArrayList<>();
        allWords.add("abcd");
        allWords.add("abcde");
        allWords.add("abcfe");
        allWords.add("abd");
        allWords.add("abdksd");
        allWords.add("abbpsd");

        ac.addWords(allWords);

        List<String> ans = ac.getPredictions("ab");
        System.out.println(ans);


    }
}
