package leetcode.YY20.MM05;

import java.util.HashMap;
import java.util.Map;

public class DD18_PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            map1.put(c1, map1.containsKey(c1) ? map1.get(c1) + 1 : 1);

            char c2 = s2.charAt(i);
            map2.put(c2, map2.containsKey(c2) ? map2.get(c2) + 1 : 1);
        }

        if (isPermutation(map1, map2)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            char previous = s2.charAt(i - s1.length());
            char current = s2.charAt(i);

            map2.put(previous, map2.get(previous) - 1);
            map2.put(current, map2.containsKey(current) ? map2.get(current) + 1 : 1);

            if (isPermutation(map1, map2)) return true;
        }

        return false;
    }

    private static boolean isPermutation(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (char c : map1.keySet()) {
            if (!map2.containsKey(c) || !map2.get(c).equals(map1.get(c))) return false;
        }

        return true;
    }
}
