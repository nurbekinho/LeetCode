package leetcode.YY20.MM06;

import leetcode.TreeNode;

public class DD01_InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = invertTree(root);
        System.out.println("   " + inverted.val);
        System.out.println(" " + inverted.left.val + "   " + inverted.right.val);
        System.out.println(inverted.left.left.val + " " + inverted.left.right.val + " " + inverted.right.left.val + " " + inverted.right.right.val);
        System.out.println();
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root != null) flip(root);
        return root;
    }

    private static void flip(TreeNode node) {
        if (node.left != null || node.right != null) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;

            if (left != null) flip(left);
            if (right != null) flip(right);
        }
    }
}
