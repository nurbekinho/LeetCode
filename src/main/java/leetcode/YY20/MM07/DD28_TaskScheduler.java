package leetcode.YY20.MM07;

import java.util.*;

public class DD28_TaskScheduler {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for(char task : tasks) map.put(task, map.getOrDefault(task, 0) + 1);

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(map.values());

        int units = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!queue.isEmpty()) list.add(queue.remove());
            }

            for (int i : list){
                if (--i > 0) queue.add(i);
            }

            units += queue.isEmpty() ? list.size() : n + 1;
        }

        return units;
    }
}
