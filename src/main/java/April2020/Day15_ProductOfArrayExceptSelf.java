package April2020;

import java.util.Arrays;

public class Day15_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{2, 2, 5, 3, 4}))); // [120, 120, 48, 80, 60]
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) result[i] = (i == 0) ? 1 : nums[i - 1] * result[i - 1];

        int temp = 1;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            result[i] *= temp;
            temp *= nums[i];
        }

        return result;
    }
}
