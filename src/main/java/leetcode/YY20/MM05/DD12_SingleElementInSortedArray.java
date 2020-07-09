package leetcode.YY20.MM05;

public class DD12_SingleElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 2, 4, 4, 5, 5, 9}));
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length <= 1) return nums[0];

        int li = 0;
        int ri = nums.length - 1;
        int mi = (ri - li) / 2;

        while (true) {
            if (nums[mi] != nums[mi - 1] && nums[mi] != nums[mi + 1]) return nums[mi];
            if (ri - li <= 2) return (nums[li] == nums[li + 1]) ? nums[ri] : nums[li];

            if (mi % 2 == 0) {
                if (nums[mi] == nums[mi - 1]) ri = mi;
                else li = mi;
            } else {
                if (nums[mi] == nums[mi + 1]) ri = mi - 1;
                else li = mi + 1;
            }

            mi = li + (ri - li) / 2;
        }
    }
}
