package ThirtyDayLeetCodingChallenge;

public class Day20_ConstructBinarySearchTree {
    public static void main(String[] args) {
        printTreeNode(bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode temp = root;
            int headValue = temp.val;
            int current = preorder[i];

            while (true) {
                if (current < headValue) {
                    if (temp.left == null) {
                        temp.left = new TreeNode(current);
                        break;
                    } else {
                        temp = temp.left;
                        headValue = temp.val;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = new TreeNode(current);
                        break;
                    } else {
                        temp = temp.right;
                        headValue = temp.val;
                    }
                }
            }
        }

        return root;
    }

    private static void printTreeNode(TreeNode treeNode) {
        System.out.print(treeNode.val + " ");
        if (treeNode.left != null) printTreeNode(treeNode.left);
        if (treeNode.right != null) printTreeNode(treeNode.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
