package ThirtyDayLeetCodingChallenge;

import java.util.HashMap;
import java.util.Map;

public class Day7_CountingElements {
    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1, 2, 3}) == 2);
        System.out.println(countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}) == 0);
        System.out.println(countElements(new int[]{1, 3, 2, 3, 5, 0}) == 3);
        System.out.println(countElements(new int[]{1, 1, 2, 2}) == 2);
    }

    public static int countElements(int[] arr) {
        int count = 0;

        Map<Integer, Integer> dict = new HashMap<>();
        for (int n : arr) {
            if (!dict.containsKey(n)) dict.put(n, 0);
            dict.put(n, dict.get(n) + 1);
        }

        for (int n : arr) {
            if (dict.containsKey(n + 1)) count++;
        }

        return count;
    }
}
