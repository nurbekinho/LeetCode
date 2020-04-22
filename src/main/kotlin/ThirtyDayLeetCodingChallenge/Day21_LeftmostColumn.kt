import ThirtyDayLeetCodingChallenge.Day21_LeftmostColumn

fun main() {
    var bm = BinaryMatrix(
        arrayOf(
            intArrayOf(0, 0, 0, 1),
            intArrayOf(0, 0, 1, 1),
            intArrayOf(0, 1, 1, 1)
        )
    )
    println(leftMostColumnWithOne(bm))

    bm = BinaryMatrix(
        arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1)
        )
    )
    println(leftMostColumnWithOne(bm))

    bm = BinaryMatrix(
        arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0)
        )
    )
    println(leftMostColumnWithOne(bm))

    bm = BinaryMatrix(arrayOf(intArrayOf(1)))
    println(leftMostColumnWithOne(bm))

    bm = BinaryMatrix(arrayOf(intArrayOf(0, 0), intArrayOf(1, 1)))
    println(leftMostColumnWithOne(bm))
}

fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
    var i = 0
    var j = binaryMatrix.dimensions()[1] - 1
    var index = -1

    while (i <= binaryMatrix.dimensions()[0] - 1 && j >= 0) {
        if (binaryMatrix[i, j] == 1) {
            index = j
            j--
        } else i++
    }

    return index
}

class BinaryMatrix(private val matrix: Array<IntArray>) {
    operator fun get(x: Int, y: Int): Int {
        return matrix[x][y]
    }

    fun dimensions(): List<Int> {
        return listOf(matrix.size, matrix[0].size)
    }

}
