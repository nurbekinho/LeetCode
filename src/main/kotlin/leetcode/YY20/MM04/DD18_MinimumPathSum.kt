import kotlin.math.min

fun main() {
    println(
        minPathSum(
            arrayOf(
                intArrayOf(1, 3, 1),
                intArrayOf(1, 5, 1),
                intArrayOf(4, 2, 1)
            )
        )
    )
}

fun minPathSum(grid: Array<IntArray>): Int {
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            grid[i][j] += when {
                i == 0 && j == 0 -> 0
                i == 0 -> grid[i][j - 1]
                j == 0 -> grid[i - 1][j]
                else -> min(grid[i][j - 1], grid[i - 1][j])
            }
        }
    }

    return grid[grid.size - 1][grid[0].size - 1]
}
