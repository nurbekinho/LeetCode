package leetcode.YY20.MM09;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DD05_AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        System.out.println(getAllElements(root1, root2));
        System.out.println(getAllElements(null, root2));
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> elements = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root1 != null) stack.add(root1);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            elements.add(current.val);

            if (current.right != null) stack.add(current.right);
            if (current.left != null) stack.add(current.left);
        }

        if (root2 != null) stack.add(root2);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            elements.add(current.val);

            if (current.right != null) stack.add(current.right);
            if (current.left != null) stack.add(current.left);
        }

        Collections.sort(elements);

        return elements;
    }
}
