package cheatsheet;

public class ImplementTrie {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean wordEnds;
    }

    static class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.wordEnds = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
            return curr.wordEnds;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(char c : prefix.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
            return true;
        }
    }
}
