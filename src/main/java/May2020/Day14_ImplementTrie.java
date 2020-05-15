package May2020;

import java.util.HashSet;
import java.util.Set;

public class Day14_ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    static class Trie {
        Set<String> words;
        Set<String> prefixes;

        /** Initialize your data structure here. */
        public Trie() {
            words = new HashSet<>();
            prefixes = new HashSet<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            words.add(word);
            if (!prefixes.contains(word)) {
                StringBuilder sb = new StringBuilder();
                for (String s : word.split("")) {
                    sb.append(s);
                    prefixes.add(sb.toString());
                }
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return words.contains(word);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return prefixes.contains(prefix);
        }
    }

}
