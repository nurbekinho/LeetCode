package July2020;

import java.util.*;

public class Day8_3Sum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        if (nums == null || nums.length < 3) return result;

        for (int n : nums) map.put(n, map.containsKey(n) ? map.get(n) + 1 : 1);
        List<Integer> list = new ArrayList<>(map.keySet());

        if (map.containsKey(0) && map.get(0) >= 3) {
            result.add(Arrays.asList(0, 0, 0));
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int a = list.get(i);
                int b = list.get(j);
                int c = -1 * (a + b);
                if (map.containsKey(c)) {
                    Integer[] r = new Integer[]{a, b, c};
                    Arrays.sort(r);
                    String v = r[0] + "_" + r[1] + "_" + r[2];
                    if ((c == a || c == b) && map.get(c) < 2) continue;
                    if (c == a && a == b && map.get(c) < 3) continue;
                    if (!set.contains(v)) {
                        result.add(Arrays.asList(r));
                        set.add(v);
                    }
                }
            }
        }

        return result;
    }
}
