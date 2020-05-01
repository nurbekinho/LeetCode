fun main() {
    println(
        maximalSquare(
            arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0')
            )
        )
    )

    println(
        maximalSquare(
            arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0')
            )
        )
    )

    println(maximalSquare(arrayOf(charArrayOf('1'))))
}

fun maximalSquare(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty()) return 0

    val rows = matrix.size
    val cols: Int = matrix[0].size
    var max = 0
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (matrix[i][j] == '1') {
                var length = 1
                var zeroExists = false
                while (length + i < rows && length + j < cols && !zeroExists) {
                    for (k in j..length + j) {
                        if (matrix[i + length][k] == '0') {
                            zeroExists = true
                            break
                        }
                    }
                    for (k in i..length + i) {
                        if (matrix[k][j + length] == '0') {
                            zeroExists = true
                            break
                        }
                    }
                    if (!zeroExists) length++
                }
                max = Math.max(max, length)
            }
        }
    }

    return Math.pow(max.toDouble(), 2.0).toInt()
}
