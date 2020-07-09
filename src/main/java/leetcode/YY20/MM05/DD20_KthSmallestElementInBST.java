package leetcode.YY20.MM05;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class DD20_KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(kthSmallest(root, 1));

        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        System.out.println(kthSmallest(root, 3));
    }

    private static boolean found = false;

    public static int kthSmallest(TreeNode root, int k) {
        found = false;

        List<Integer> result = new ArrayList<>();
        return getOrderedList(root, result, k).get(k - 1);
    }

    private static List<Integer> getOrderedList(TreeNode n, List<Integer> result, int k) {
        if (found) return null;

        if (n.left != null) getOrderedList(n.left, result, k);

        result.add(n.val);

        if (n.right != null) getOrderedList(n.right, result, k);

        if (result.size() >= k) {
            found = true;
            return result;
        }

        return null;
    }
}
