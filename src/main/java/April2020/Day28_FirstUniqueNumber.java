package April2020;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Day28_FirstUniqueNumber {
    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[]{2,3,5});
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1

        firstUnique = new FirstUnique(new int[]{7,7,7,7,7,7});
        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        System.out.println(firstUnique.showFirstUnique()); // return 17

        firstUnique = new FirstUnique(new int[]{809});
        System.out.println(firstUnique.showFirstUnique()); // return 809
        firstUnique.add(809);          // the queue is now [809,809]
        System.out.println(firstUnique.showFirstUnique()); // return -1
    }
}


class FirstUnique {
    Queue<Integer> queue;
    Map<Integer, Integer> map;

    public FirstUnique(int[] nums) {
        queue = new LinkedList<>();
        map = new HashMap<>();

        for (int n : nums) {
            queue.add(n);
            map.put(n, map.containsKey(n) ? map.get(n) + 1 : 1);
        }
    }

    public int showFirstUnique() {
        if (queue.size() <= 0) return -1;
        if (map.get(queue.peek()) > 1) {
            queue.poll();
            return showFirstUnique();
        }

        return queue.peek();
    }

    public void add(int value) {
        map.put(value, map.containsKey(value) ? map.get(value) + 1 : 1);
        if (map.get(value) <= 1) queue.add(value);
    }
}
