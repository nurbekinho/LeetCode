import java.util.*

fun main() {
    println(
        numIslands(
            arrayOf(
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray()
            )
        )
    )

    println(
        numIslands(
            arrayOf(
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
            )
        )
    )

    println(
        numIslands(
            arrayOf(
                "111".toCharArray(),
                "010".toCharArray(),
                "111".toCharArray()
            )
        )
    )
}

fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty()) return 0

    val earth = Array(grid.size + 2) { IntArray(grid[0].size + 2) }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            earth[i + 1][j + 1] = grid[i][j].toString().toInt()
        }
    }

    var count = 0
    val visited: MutableSet<String> = HashSet()
    for (i in 1 until earth.size - 1) {
        for (j in 1 until earth[i].size - 1) {
            if (visited.contains(i.toString() + "_" + j)) continue
            if (earth[i][j] == 1) {
                count++
                findEdges(i, j, earth, visited)
            }
        }
    }
    return count
}

private fun findEdges(
    i: Int,
    j: Int,
    earth: Array<IntArray>,
    visited: MutableSet<String>
) {
    val coordinate = i.toString() + "_" + j
    if (earth[i][j] == 0 || visited.contains(coordinate)) return
    visited.add(coordinate)

    if (earth[i + 1][j] == 1) findEdges(i + 1, j, earth, visited)
    if (earth[i - 1][j] == 1) findEdges(i - 1, j, earth, visited)
    if (earth[i][j + 1] == 1) findEdges(i, j + 1, earth, visited)
    if (earth[i][j - 1] == 1) findEdges(i, j - 1, earth, visited)
}
