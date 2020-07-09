package leetcode.YY20.MM06;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DD26_SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));

        root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        List<Integer> numbers = new ArrayList<>();

        findNumbers(root, numbers, Integer.toString(root.val));

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    private static void findNumbers(TreeNode root, List<Integer> numbers, String value) {
        if (root.left == null && root.right == null) numbers.add(Integer.parseInt(value));
        if (root.left != null) findNumbers(root.left, numbers, value + root.left.val);
        if (root.right != null) findNumbers(root.right, numbers, value + root.right.val);
    }
}
