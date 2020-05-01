package April2020;

import java.util.*;

public class Day6_GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        for (String str : strs) {
            String sorted = Arrays.toString(str.chars().mapToObj(c -> (char) c).sorted().toArray());
            if (!dict.containsKey(sorted)) dict.put(sorted, new ArrayList<>());
            dict.get(sorted).add(str);
        }

        return new ArrayList<>(dict.values());
    }
}
