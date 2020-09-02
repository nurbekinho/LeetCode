package leetcode.Problems;

import leetcode.TreeNode;

public class LC0110_BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
