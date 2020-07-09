package leetcode.YY20.MM04;

import leetcode.TreeNode;

public class DD30_ValidSequence {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);

        System.out.println(isValidSequence(root, new int[]{0, 1, 2, 3}));
    }

    private static boolean isValid = false;

    public static boolean isValidSequence(TreeNode root, int[] arr) {
        check(root, arr, 0);
        return isValid;
    }

    private static void check(TreeNode root, int[] arr, int i) {
        if (isValid || i >= arr.length || root.val != arr[i]) return;
        if (i == arr.length - 1 && root.val == arr[i] && root.left == null && root.right == null) {
            isValid = true;
            return;
        }

        if (root.left != null) check(root.left, arr, i + 1);
        if (root.right != null) check(root.right, arr, i + 1);
    }

    /*static class leetcode.TreeNode {
        int val;
        leetcode.TreeNode left;
        leetcode.TreeNode right;
        leetcode.TreeNode() {}
        leetcode.TreeNode(int val) { this.val = val; }
        leetcode.TreeNode(int val, leetcode.TreeNode left, leetcode.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }*/
}
