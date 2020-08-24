package leetcode.YY20.MM08;

import java.util.HashMap;
import java.util.Map;

public class DD23_StreamOfCharacters {
    public static void main(String[] args) {

    }
}

class StreamChecker {
    private StringBuilder sb;
    private TrieNode node;

    public StreamChecker(String[] words) {
        sb = new StringBuilder();
        node = new TrieNode();
        for (String word : words)
            insert(new StringBuilder(word).reverse().toString());
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = this.node;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            char c = sb.charAt(i);
            node = node.next.get(c);

            if (node != null && node.isWord) return true;
        }

        return false;
    }

    class TrieNode {
        Map<Character, TrieNode> next;
        boolean isWord;

        public TrieNode() {
            next = new HashMap();
        }
    }

    public void insert(String word) {
        TrieNode current = node;
        for (char c : word.toCharArray()) {
            TrieNode node = current.next.getOrDefault(c, new TrieNode());
            current.next.put(c, node);
            current = node;
        }

        current.isWord = true;
    }
}