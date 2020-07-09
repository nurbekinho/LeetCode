package leetcode.YY20.MM05;

import java.util.HashMap;
import java.util.Map;

public class DD10_FindTheTownJudge {
    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{
                {1, 2}
        }));

        System.out.println(findJudge(3, new int[][]{
                {1, 3},
                {2, 3}
        }));

        System.out.println(findJudge(3, new int[][]{
                {1, 3},
                {2, 3},
                {3, 1}
        }));

        System.out.println(findJudge(3, new int[][]{
                {1, 2},
                {2, 3}
        }));

        System.out.println(findJudge(4, new int[][]{
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        }));
    }

    public static int findJudge(int N, int[][] trust) {
        if (trust.length <= 0) return N;

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : trust) {
            map.put(t[0], map.containsKey(t[0]) ? map.get(t[0]) - 1 : -1);
            map.put(t[1], map.containsKey(t[1]) ? map.get(t[1]) + 1 : 1);
        }

        for (int i = 1; i <= N; i++) {
            if (map.containsKey(i) && map.get(i) == N - 1) return i;
        }

        return -1;
    }
}
