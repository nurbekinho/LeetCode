package leetcode.YY20.MM08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DD05_AddAndSearchWord {
    public static void main(String[] args) {

    }
}

class WordDictionary {
    /** Initialize your data structure here. */
    Map<Integer, Set<String>> map = new HashMap<>();

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int length = word.length();
        if (!map.containsKey(length)) {
            map.put(length, new HashSet<>());
        }

        map.get(length).add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int length = word.length();
        if (map.containsKey(length)) {
            Set<String> set = map.get(length);
            for (String s : set) {
                int letterCount = 0;
                int similar = 0;
                for (int i = 0; i < length; i++) {
                    if (word.charAt(i) != '.') {
                        letterCount++;
                        if (word.charAt(i) == s.charAt(i)) similar++;
                    }
                }

                if (similar == letterCount) return true;
            }
        }

        return false;
    }
}