package leetcode.YY20.MM07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DD23_SingleNumberIII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 3, 3, 4, 4, 5, 5})));
    }

    public static int[] singleNumber(int[] nums) {
        if (nums.length == 0) return new int[2];

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }

        return set.stream().mapToInt(element -> element).toArray();
    }
}
