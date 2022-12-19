import leetcode.TreeNode
import java.util.Stack

fun main() {

}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = Stack<TreeNode>()
    var current = root

    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.add(current)
            current = current.left
        }

        current = stack.pop()
        result.add(current.`val`)
        current = current.right
    }

    return result
}