import leetcode.TreeNode

fun main() {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(11)
    root.right.right = TreeNode(-3)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(2)
    root.left.left.left = TreeNode(3)
    root.left.left.right = TreeNode(-2)
    root.left.right.right = TreeNode(1)

    println(pathSum(root, 3))
}

fun pathSum(root: TreeNode?, sum: Int): Int {
    return if (root == null) 0 else findSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum)
}

private fun findSum(node: TreeNode?, sum: Int): Int {
    return if (node == null) 0 else (if (node.`val` == sum) 1 else 0) + findSum(node.left, sum - node.`val`) + findSum(node.right, sum - node.`val`)
}