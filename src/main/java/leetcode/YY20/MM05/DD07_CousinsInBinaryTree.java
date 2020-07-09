package leetcode.YY20.MM05;

import leetcode.TreeNode;

public class DD07_CousinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(isCousins(root, 4, 3));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        System.out.println(isCousins(root, 5, 4));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(isCousins(root, 2, 3));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) return false;

        TreeNode[] parents = new TreeNode[2];
        int[] depths = new int[2];
        findXY(root, 0, x, y, parents, depths);

        return parents[0] != parents[1] && depths[0] == depths[1];
    }

    private static void findXY(TreeNode root, int depth, int x, int y, TreeNode[] parents, int[] depths) {
        if (root.left != null) {
            if (root.left.val == x) {
                parents[0] = root;
                depths[0] = depth + 1;
            } else if (root.left.val == y) {
                parents[1] = root;
                depths[1] = depth + 1;
            } else {
                findXY(root.left, depth + 1, x, y, parents, depths);
            }
        }

        if (root.right != null) {
            if (root.right.val == x) {
                parents[0] = root;
                depths[0] = depth + 1;
            } else if (root.right.val == y) {
                parents[1] = root;
                depths[1] = depth + 1;
            } else {
                findXY(root.right, depth + 1, x, y, parents, depths);
            }
        }
    }

    /*static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }*/
}
