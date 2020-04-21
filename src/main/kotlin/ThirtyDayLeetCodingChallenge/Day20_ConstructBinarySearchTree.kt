fun main() {
    printTreeNode1(bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12)))
}

fun bstFromPreorder(preorder: IntArray): TreeNode1? {
    val root = TreeNode1(preorder[0])
    for (i in 1 until preorder.size) {
        var temp: TreeNode1? = root
        var headValue: Int = temp!!.value
        val current = preorder[i]
        while (true) {
            if (current < headValue) {
                if (temp!!.left == null) {
                    temp.left = TreeNode1(current)
                    break
                } else {
                    temp = temp.left
                    headValue = temp!!.value
                }
            } else {
                if (temp!!.right == null) {
                    temp.right = TreeNode1(current)
                    break
                } else {
                    temp = temp.right
                    headValue = temp!!.value
                }
            }
        }
    }

    return root
}

fun printTreeNode1(treeNode: TreeNode1?) {
    print(treeNode!!.value.toString() + " ")
    if (treeNode.left != null) printTreeNode1(treeNode.left)
    if (treeNode.right != null) printTreeNode1(treeNode.right)
}

class TreeNode1(var value: Int) {
    var left: TreeNode1? = null
    var right: TreeNode1? = null
}
