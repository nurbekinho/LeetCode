package leetcode.YY20.MM07;

import java.util.*;

public class DD24_AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][] {
                {1,2},
                {3},
                {3},
                {}
        }));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(0));

        int goal = graph.length - 1;
        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int lastNode = current.get(current.size() - 1);
            if (lastNode == goal) result.add(new ArrayList<>(current));
            else {
                int[] neighbour = graph[lastNode];
                for(int n: neighbour) {
                    List<Integer> temp = new ArrayList<>(current);
                    temp.add(n);
                    queue.add(temp);
                }
            }
        }

        return result;
    }
}
