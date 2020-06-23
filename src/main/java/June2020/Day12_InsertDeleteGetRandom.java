package June2020;

import java.util.*;

public class Day12_InsertDeleteGetRandom {
    public static void main(String[] args) {

    }

    static class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> map;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;

            int index = list.size();
            list.add(val);
            map.put(val, index);

            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;

            int index = map.get(val);
            int lastIndex = list.size() - 1;
            int lastElement = list.get(lastIndex);

            list.set(index, lastElement);
            map.put(lastElement, index);
            list.remove(lastIndex);
            map.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }
}

