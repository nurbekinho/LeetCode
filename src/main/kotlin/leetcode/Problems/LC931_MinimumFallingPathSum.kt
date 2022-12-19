import kotlin.math.min

fun main() {
    println(minFallingPathSum(arrayOf(
        intArrayOf(2, 1, 3),
        intArrayOf(6, 5, 4),
        intArrayOf(7, 8, 9)
    )))
}

fun minFallingPathSum(matrix: Array<IntArray>): Int {
    if (matrix.size == 1) return matrix[0][0]
    for (i in 1 until matrix.size) {
        for (j in 0 until matrix[i].size) {
            val current = matrix[i][j]
            matrix[i][j] = current + when(j) {
                0 -> min(matrix[i - 1][0], matrix[i - 1][1])
                matrix[j].size - 1 -> min(matrix[i - 1][j], matrix[i - 1][j - 1])
                else -> min(matrix[i - 1][j], min(matrix[i - 1][j + 1], matrix[i - 1][j - 1]))
            }
        }
    }

    return matrix.last().minOrNull()!!
}