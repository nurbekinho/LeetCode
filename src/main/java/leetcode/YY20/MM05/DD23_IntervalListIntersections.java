package leetcode.YY20.MM05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DD23_IntervalListIntersections {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {0, 2},
                {5, 10},
                {13, 23},
                {24, 25}
        };

        int[][] B = new int[][]{
                {1, 5},
                {8, 12},
                {15, 24},
                {25, 26}
        };

        int[][] result = intervalIntersection(A, B);
        for (int[] r : result) System.out.println(Arrays.toString(r));

        A = new int[][]{
                {5, 10}
        };

        B = new int[][]{
                {5, 10}
        };

        result = intervalIntersection(A, B);
        for (int[] r : result) System.out.println(Arrays.toString(r));
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<String> resultList = new ArrayList<>();
        int bi = 0;
        for (int[] a : A) {
            int s1 = a[0];
            int e1 = a[1];

            for (int i = bi; i < B.length; i++) {
                int s2 = B[i][0];
                int e2 = B[i][1];

                if (s1 > e2) {
                    bi = i;
                } else if (s2 > e1) {
                    break;
                } else if (s1 >= s2) {
                    //System.out.println(s1 + " - " + Math.min(e1, e2));
                    resultList.add(s1 + "-" + Math.min(e1, e2));
                } else {
                    //System.out.println(s2 + " + " + Math.min(e1, e2));
                    resultList.add(s2 + "-" + Math.min(e1, e2));
                }
            }
        }

        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < result.length; i++) {
            String[] s = resultList.get(i).split("-");
            result[i] = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
        }

        return result;
    }
}
