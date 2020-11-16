package leetcode.Problems;

import leetcode.TreeNode;

public class LC0938_RangeSumOfBST {
    private static int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(root, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        find(root, low, high);
        return sum;
    }

    private static void find(TreeNode root, int low, int high) {
        if (root.val >= low && root.val <= high) sum += root.val;
        if (root.left != null) find(root.left, low, high);
        if (root.right != null) find(root.right, low, high);
    }
}
