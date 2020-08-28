package leetcode.YY20.MM08;

import java.util.TreeMap;

public class DD27_FindRightInterval {
    public static void main(String[] args) {

    }

    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] result = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) map.put(intervals[i][0], i);
        for (int i = 0; i < intervals.length; i++) result[i] = map.ceilingKey(intervals[i][1]) == null ? -1 : map.get(map.ceilingKey(intervals[i][1]));

        return result;
    }
}
