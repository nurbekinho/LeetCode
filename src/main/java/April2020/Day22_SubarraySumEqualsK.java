package April2020;

import java.util.HashMap;
import java.util.Map;

public class Day22_SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum(new int[]{1,1,1,1,1,1,1,1,-1,2}, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;

        int[] sums = new int[nums.length];
        for (int i = 0; i < sums.length; i++) {
            sums[i] += nums[i] + (i == 0 ? 0 : sums[i -1]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int sum : sums) {
            if (sum == k) count++;
            if (map.containsKey(sum - k)) count += map.get(sum - k);

            map.put(sum, (map.containsKey(sum) ? map.get(sum) + 1 : 1));
        }

        return count;
    }
}
