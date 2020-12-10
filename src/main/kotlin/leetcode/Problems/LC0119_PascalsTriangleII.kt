fun main() {
    println(getRow(3))
}

fun getRow(rowIndex: Int): List<Int> {
    val matrix = Array(34) { IntArray(81) {0} }
    matrix[0][40] = 1
    for (i in 1..33) {
        for (j in 1..79) {
            matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j + 1]
        }
    }

    return matrix[rowIndex].filter { it > 0 }
}