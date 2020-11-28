import leetcode.TreeNode
import kotlin.math.max

fun main() {

}

fun rob(root: TreeNode?): Int {
    if (root == null) return 0
    return dfs(root, false)
}

fun dfs(root: TreeNode?, taken: Boolean): Int {
    if (root == null) return 0
    return if (taken) dfs(root.left, false) + dfs(root.right, false)
    else max(root.`val` + dfs(root.left, true) + dfs(root.right, true),
        dfs(root.left, false) + dfs(root.right, false))
}

/*
story writing and providing test cases
codebase 10-12 developers
*/