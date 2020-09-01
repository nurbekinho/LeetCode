package leetcode.YY20.MM08;

import leetcode.TreeNode;

public class DD31_DeleteNodeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode.printNodesDFS(deleteNode(root, 3));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key == root.val) {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode leftCopy = root.left;
            while (leftCopy.right != null) leftCopy = leftCopy.right;
            leftCopy.right = root.right;
            root.right = null;

            return root.left;
        } else {
            root.left = deleteNode(root.left,key);
            root.right = deleteNode(root.right,key);
        }

        return root;
    }
}
