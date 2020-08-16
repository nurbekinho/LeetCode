package leetcode.YY20.MM08;

import java.util.Arrays;
import java.util.Comparator;

public class DD15_NonOverlappingIntervals {
    public static void main(String[] args) {

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        if (intervals.length <= 0) return count;

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(end > intervals[i][0]) {
                end = Math.min(end, intervals[i][1]);
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }
}
