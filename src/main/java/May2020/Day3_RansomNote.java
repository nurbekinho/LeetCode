package May2020;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Day3_RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b")); //false
        System.out.println(canConstruct("aa", "ab")); //false
        System.out.println(canConstruct("aa", "aab")); //true
        System.out.println(canConstruct("", "a")); //true
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() <= 0) return true;

        Map<String, Long> noteMap = Arrays
                .stream(ransomNote.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Map<String, Long> magMap = Arrays
                .stream(magazine.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        for (Map.Entry<String, Long> m : noteMap.entrySet()) {
            if (!magMap.containsKey(m.getKey()) || magMap.get(m.getKey()) < m.getValue()) return false;
        }

        return true;
    }
}
