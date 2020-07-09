package leetcode.YY20.MM05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DD27_PossibleBipartition {
    public static void main(String[] args) {
        System.out.println(possibleBipartition(4, new int[][]{
                {1, 2},
                {1, 3},
                {2, 4}
        }));

        System.out.println(possibleBipartition(3, new int[][]{
                {1, 2},
                {1, 3},
                {2, 3}
        }));
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] groups = new int[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int[] d : dislikes) {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= N; i++) {
            if (groups[i] == 0) {
                groups[i] = 1;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int q = queue.poll();
                    for (int j : graph.get(q)) {
                        if (groups[j] == 0) {
                            groups[j] = (groups[q] == 1) ? 2 : 1;
                            queue.add(j);
                        } else if (groups[q] == groups[j]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean possibleBipartition2(int N, int[][] dislikes) {
        int[] group = new int[N+1];
        for (int i = 0; i <= N; i++) {
            group[i] = i; // initial
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            if (group[a] == a && group[b] == b) {
                group[a] = b;
                group[b] = a;
            } else if (group[a] == a && group[b] != b) {
                // let a go to group that all hate b;
                group[a] = group[group[b]];
            } else if (group[b] ==b && group[a] != a) {
                group[b] = group[group[a]];
            } else if (group[b] == group[a]) {
                return false;
            }
        }
        return true;
    }
}
