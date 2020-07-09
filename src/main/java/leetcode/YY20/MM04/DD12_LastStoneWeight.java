package leetcode.YY20.MM04;

import java.util.PriorityQueue;

public class DD12_LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> e2 - e1);
        for (int stone : stones) queue.add(stone);

        while (queue.size() > 0) {
            if (queue.size() == 1) break;

            int last = queue.poll();
            int previous = queue.poll();
            if (last != previous) queue.add(last - previous);
        }

        return queue.size() > 0 ? queue.poll() : 0;
    }
}
