package leetcode.YY20.MM07;

import leetcode.TreeNode;

public class DD27_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        TreeNode.printNodesDFS(buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder, int start, int iEnd, int pEnd) {
        if (pEnd < 0 || start > iEnd) return null;

        TreeNode root= new TreeNode(postorder[pEnd]);
        int i = start;
        while (i < iEnd) {
            if (inorder[i] == root.val) break;
            i++;
        }

        root.left = buildTree(inorder, postorder, start, i - 1, pEnd - 1 + i - iEnd);
        root.right = buildTree(inorder, postorder, i + 1, iEnd, pEnd - 1);
        return root;
    }
}
