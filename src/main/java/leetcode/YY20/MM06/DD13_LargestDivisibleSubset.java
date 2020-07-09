package leetcode.YY20.MM06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DD13_LargestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
        //System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        int[] numbers = new int[nums.length];
        int[] indexes = new int[nums.length];
        int maxNum = 0;
        int maxInd = -1;

        Arrays.sort(nums);
        Arrays.fill(numbers, 1);
        Arrays.fill(indexes, -1);

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && numbers[j] + 1 > numbers[i]) {
                    numbers[i] = numbers[j] + 1;
                    indexes[i] = j;
                }
            }

            if (maxNum < numbers[i]) {
                maxNum = numbers[i];
                maxInd = i;
            }
        }

        /*System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(indexes));*/

        int i = maxInd;
        while (i >= 0){
            result.add(nums[i]);
            i = indexes[i];
        }

        return result;
    }
}
