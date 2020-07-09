package leetcode.YY20.MM04;

import java.util.LinkedHashMap;
import java.util.Map;

public class DD24_LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    static class LRUCache {
        private Map<Integer, Integer> map;
        private int capacity;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.remove(key);
                map.put(key, value);
                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) map.remove(key);
            else if (map.size() >= capacity) map.remove(map.keySet().iterator().next());
            map.put(key, value);
        }
    }
}
