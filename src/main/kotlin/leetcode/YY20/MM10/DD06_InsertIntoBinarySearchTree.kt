import leetcode.TreeNode

fun main() {

}

fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) return TreeNode(`val`)
    if (root.`val` > `val`) root.left = insertIntoBST(root.left, `val`)
    else root.right = insertIntoBST(root.right, `val`)
    return root
}