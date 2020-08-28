package leetcode.YY20.MM08;

import leetcode.TreeNode;

public class DD24_SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sumOfLeftLeaves(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        return (root.left != null && root.left.left == null && root.left.right == null ? root.left.val : 0) + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
