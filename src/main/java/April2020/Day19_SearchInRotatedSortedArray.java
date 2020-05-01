package April2020;

public class Day19_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[left] <= nums[mid])
                if (nums[left] <= target && nums[mid] >= target) right = mid - 1;
                else left = mid + 1;
            else {
                if (nums[mid] <= target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1;
    }
}
