package May2020;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Day2_JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

    public static int numJewelsInStones(String J, String S) {
        Map<String, Long> map = Arrays
                .stream(S.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return (int) Arrays.stream(J.split("")).mapToLong(c -> map.containsKey(c) ? map.get(c) : 0).sum();
    }
}
