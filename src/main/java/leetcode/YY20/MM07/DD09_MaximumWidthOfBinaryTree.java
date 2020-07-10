package leetcode.YY20.MM07;

import leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class DD09_MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int answer = 1;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                if (node == null) {
                    deque.add(null);
                    deque.add(null);
                } else {
                    deque.add(node.left);
                    deque.add(node.right);
                }
            }

            while (!deque.isEmpty() && (deque.getFirst()==null || deque.getLast()==null)) {
                if (deque.getFirst() == null) deque.pollFirst();
                if (!deque.isEmpty() && deque.getLast() == null) deque.pollLast();
            }

            answer = Math.max(answer, deque.size());
        }

        return answer;
    }
}
