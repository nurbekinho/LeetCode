package ThirtyDayLeetCodingChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day13_ContiguousArray {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
        System.out.println(findMaxLength(new int[]{0, 1, 0, 0, 0, 0, 1, 0, 0, 1}));
    }

    public static int findMaxLength(int[] nums) {
        int zeros = (int) Arrays.stream(nums).filter(number -> number == 0).count();
        int ones = nums.length - zeros;

        if (zeros == ones) return nums.length;
        else if (zeros == nums.length || ones == nums.length) return 0;
        else {
            zeros = 0;
            ones = 0;
            int max = 0;
            Map<Integer, Integer> memo = new HashMap<>();
            memo.put(0, -1);

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) zeros++;
                else ones++;

                if (memo.containsKey(zeros - ones)) max = Math.max(max, i - memo.get(zeros - ones));
                else memo.put(zeros - ones, i);
            }

            return max;
        }
    }
}
