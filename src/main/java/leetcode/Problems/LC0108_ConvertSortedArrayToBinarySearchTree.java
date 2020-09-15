package leetcode.Problems;

import leetcode.TreeNode;

public class LC0108_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = getBST(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode getBST(int[] nums, int left, int right)
    {
        if(left > right) return null;

        int middle = (left + right) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = getBST(nums, left, middle - 1);
        node.right = getBST(nums, middle + 1, right);

        return node;
    }
}
