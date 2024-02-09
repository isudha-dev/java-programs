package interview.bookingdotcom;

import java.util.*;

public class Trie {

        public static void main(String[] args) {
            Trie trie = new Trie();
            trie.add("William");
            trie.add("williamRoma");
            trie.add("williamRoma");
            trie.add("williamRome");
            trie.add("willy");
            System.out.println(trie.calculateCompleteWords());
            Set<String> suggestions = trie.findSuggestions("Wi");
            for (String word : suggestions) {
                System.out.println(word);
            }
        }

        TrieNode root;
        public Trie() {
            root = new TrieNode(' ');
        }
        public void add(String word) {
            word = word.toLowerCase();
            add(root, word);
        }

        public Set<String> findSuggestions(String word) {
            word = word.toLowerCase();
            TrieNode node = isPrefix(word);
            if (node == null)
                return new HashSet<>();
            return findSuggestions(node, word);
        }
        private Set<String> findSuggestions(TrieNode node, String value) {
            Set<String> results = new HashSet<>();
            for (Character character : node.children.keySet()) {
                if (node.children.get(character).complete) {
                    results.add(value + character);
                }
                results.addAll(findSuggestions(node.children.get(character), value + character));
            }
            return results;
        }

        private TrieNode isPrefix(String word) {
            return isPrefix(word, root);
        }

        private TrieNode isPrefix(String word, TrieNode node) {
            if (word.isEmpty())
                return null;
            if (node == null)
                return null;
            char character = word.charAt(0);

            if (node.children.containsKey(character)) {
                if (word.length() == 1) {
                    return node.children.get(character);
                }
                return isPrefix(word.substring(1), node.children.get(character));
            }
            return null;

        }

        private void add(TrieNode node, String word) {
            if (word.isEmpty())
                return;
            char character = word.charAt(0);
            if (node == null) {
                node = new TrieNode(character);
                if (word.length() > 1) {
                    add(node, word.substring(1));
                } else {
                    node.complete = true;
                }
            } else {
                if (!node.children.containsKey(character)) {
                    TrieNode Trie2Node = new TrieNode(character);
                    node.children.put(character, Trie2Node);
                }
                if (word.length() > 1) {
                    add(node.children.get(character),
                            word.substring(1));
                } else {
                    node.children.get(character).complete = true;
                }
            }
        }

        public int calculateCompleteWords() {
            return calculateCompleteWords(root);
        }

        private int calculateCompleteWords(TrieNode node) {
            if (node == null) {
                return 0;
            }
            int count = 0;
            if (node.complete) {
                count = 1;
            }
            for (Character character : node.children.keySet()) {
                count += calculateCompleteWords(node.children.get(character));
            }
            return count;

        }
    }

    class TrieNode {
        Character character;
        Map<Character, TrieNode> children;
        boolean complete;

        public TrieNode(Character character) {
            this.character = character;
            this.children = new HashMap<>();
        }
    }

