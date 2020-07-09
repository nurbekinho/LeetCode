package leetcode.YY20.MM06;

import leetcode.TreeNode;

public class DD15_SearchInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        TreeNode result = searchBST(root, 2);
        if (result != null) TreeNode.printNodesDFS(result);
    }

    private static TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) return root;
            else if (root.val > val) return searchBST(root.left, val);
            else return searchBST(root.right, val);
        }

        return null;
    }
}
