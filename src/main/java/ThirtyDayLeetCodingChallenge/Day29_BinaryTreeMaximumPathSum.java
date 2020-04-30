package ThirtyDayLeetCodingChallenge;

public class Day29_BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));

        root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        System.out.println(maxPathSum(root));


    }

    public static int maxPathSum(TreeNode root) {
        int[] memo = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, memo);
        return memo[0];
    }

    private static int maxPathSum(TreeNode root, int[] memo) {
        if(root == null) return 0;

        int leftSum = maxPathSum(root.left, memo);
        int rightSum = maxPathSum(root.right, memo);
        int max = Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));

        memo[0] = Math.max(memo[0], Math.max(max, leftSum + root.val + rightSum));

        return max;
    }

    static class TreeNode {
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
    }
}
