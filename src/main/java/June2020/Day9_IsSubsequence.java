package June2020;

import java.util.Set;
import java.util.stream.Collectors;

public class Day9_IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("ace", "abcde"));
        System.out.println(isSubsequence("aec", "abcde"));
        System.out.println(isSubsequence("abc", "ahbgdccc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    private static boolean isSubsequence(String s, String t) {
        /*Set<Character> sSet = s.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        Set<Character> tSet = t.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

        for (char c : sSet) {
            if (!tSet.contains(c)) return false;
        }*/

        int lastIndex = 0;
        for (char c : s.toCharArray()) {
            boolean found = false;
            for (int i = lastIndex; i < t.length(); i++) {
                if (t.charAt(i) == c) {
                    found = true;
                    lastIndex = i + 1;
                    break;
                }
            }

            if (!found) return false;
        }

        return true;
    }
}
