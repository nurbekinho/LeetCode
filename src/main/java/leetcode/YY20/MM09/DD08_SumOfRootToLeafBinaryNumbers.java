package leetcode.YY20.MM09;

import leetcode.TreeNode;

public class DD08_SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(sumRootToLeaf(root));
    }

    static int sum = 0;

    public static int sumRootToLeaf(TreeNode root) {
        if (root != null) findAndAdd("" + root.val, root);
        return sum;
    }

    private static void findAndAdd(String s, TreeNode node) {
        if (node.left == null && node.right == null) sum += Integer.parseInt(s, 2);

        if (node.left != null) findAndAdd(s + node.left.val, node.left);
        if (node.right != null) findAndAdd(s + node.right.val, node.right);
    }
}
