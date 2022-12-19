fun main() {
    val root1 = TreeNode(3)
    root1.left = TreeNode(5)
    root1.left!!.left = TreeNode(6)
    root1.left!!.right = TreeNode(2)
    root1.left!!.right!!.left = TreeNode(7)
    root1.left!!.right!!.right = TreeNode(4)
    root1.right = TreeNode(1)
    root1.right!!.left = TreeNode(9)
    root1.right!!.right = TreeNode(8)

    leafSimilar(root1, TreeNode(1))
}

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val last1 = mutableListOf<Int>()
    val last2 = mutableListOf<Int>()

    findLastOnes(root1, last1)
    findLastOnes(root2, last2)

    return last1 == last2
}

fun findLastOnes(root: TreeNode?, last: MutableList<Int>) {
    if (root != null) {
        if (root.left == null && root.right == null) last.add(root.`val`)
        else {
            findLastOnes(root.left, last)
            findLastOnes(root.right, last)
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}