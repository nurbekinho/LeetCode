package May2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day17_FindAllAnagramsInString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char sChar = s.charAt(i);
            sMap.put(sChar, sMap.containsKey(sChar) ? sMap.get(sChar) + 1 : 1);

            char pChar = p.charAt(i);
            pMap.put(pChar, pMap.containsKey(pChar) ? pMap.get(pChar) + 1 : 1);
        }

        if (isAnagrams(sMap, pMap)) result.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            char prev = s.charAt(i - p.length());
            char sChar = s.charAt(i);

            sMap.put(prev, sMap.get(prev) - 1);
            sMap.put(sChar, sMap.containsKey(sChar) ? sMap.get(sChar) + 1 : 1);

            if (isAnagrams(sMap, pMap)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    private static boolean isAnagrams(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (char c : map2.keySet()) {
            if (!map1.containsKey(c) || !map1.get(c).equals(map2.get(c))) return false;
        }

        return true;
    }
}
