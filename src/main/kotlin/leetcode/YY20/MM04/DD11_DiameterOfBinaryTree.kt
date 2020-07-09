import leetcode.TreeNode
import kotlin.math.max

fun main() {
    val node = TreeNode(1)
    node.left = TreeNode(2)
    node.right = TreeNode(3)
    node.left!!.left = TreeNode(4)
    node.left!!.right = TreeNode(5)

    println(diameterOfBinaryTree(node))
}

private fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) return 0
    val outer = getMaxLength(root.left) + getMaxLength(root.right)
    val inner = max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right))
    return max(outer, inner)
}

private fun getMaxLength(node: TreeNode?): Int {
    return if (node == null) 0 else 1 + max(getMaxLength(node.left), getMaxLength(node.right))
}

/*internal class leetcode.TreeNode internal constructor(var value: Int) {
    var left: leetcode.TreeNode? = null
    var right: leetcode.TreeNode? = null
}*/
