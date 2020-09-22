package leetcode.YY20.MM09;

import java.util.Map;
import java.util.TreeMap;

public class DD21_CarPooling {
    public static void main(String[] args) {

    }

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] trip : trips) {
            int passengers = trip[0];
            map.put(trip[1], map.getOrDefault(map.get(trip[1]), 0) + passengers);
            map.put(trip[2], map.getOrDefault(map.get(trip[2]), 0) - passengers);
        }

        int current = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            current += entry.getValue();
            if (current > capacity) return false;
        }

        return true;
    }
}
