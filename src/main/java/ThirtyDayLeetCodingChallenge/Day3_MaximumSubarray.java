package ThirtyDayLeetCodingChallenge;

public class Day3_MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) == 6);
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;

        for (int i = 0; i < nums.length; i++)
        {
            current = current + nums[i];
            if (max < current) max = current;
            if (current < 0) current = 0;
        }

        return max;
    }
}
