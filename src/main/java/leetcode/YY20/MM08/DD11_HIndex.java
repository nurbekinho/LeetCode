package leetcode.YY20.MM08;

import java.util.Arrays;

public class DD11_HIndex {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) return citations.length - i;
        }

        return 0;
    }
}
