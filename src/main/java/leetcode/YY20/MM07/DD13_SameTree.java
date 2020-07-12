package leetcode.YY20.MM07;

import leetcode.TreeNode;

public class DD13_SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(isSameTree(p, q));

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        q = new TreeNode(1);
        q.right = new TreeNode(2);
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        String pS = getTreeValues(p);
        String pQ = getTreeValues(q);
        return pS.equals(pQ);
    }

    private static String getTreeValues(TreeNode p) {
        if (p != null) return p.val + "L" + getTreeValues(p.left) + "R" + getTreeValues(p.right);
        return "";
    }
}
