package ThirtyDayLeetCodingChallenge;

public class Day25_JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{4, 3, 2, 2, 0, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int currentIndex = 0;
        for (int i = 0; i < nums.length && i <= currentIndex; i++) {
            currentIndex = Math.max(i + nums[i], currentIndex);
        }

        return currentIndex >= nums.length - 1;
    }
}
