package leetcode.YY20.MM04;

import leetcode.TreeNode;

public class DD11_DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(node));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int outer = getMaxLength(root.left) + getMaxLength(root.right);
        int inner = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(outer, inner);
    }

    private static int getMaxLength(TreeNode node) {
        return (node == null) ? 0 : 1 + Math.max(getMaxLength(node.left), getMaxLength(node.right));
    }
}
