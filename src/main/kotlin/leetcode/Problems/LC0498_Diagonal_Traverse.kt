import java.util.*

fun main() {
    /*println(findDiagonalOrder(arrayOf(
        intArrayOf(1, 2, 3, 4, 5, 6, 7)
    )).contentToString())

    println(findDiagonalOrder(arrayOf(
        intArrayOf(1),
        intArrayOf(2),
        intArrayOf(3)
    )).contentToString())

    println(findDiagonalOrder(arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )).contentToString())*/

    println(findDiagonalOrder(arrayOf(
        intArrayOf( 1, 2,  3,  4),
        intArrayOf( 5, 6,  7,  8),
        intArrayOf( 9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16)
    )).contentToString())
}

fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
    if (matrix == null || matrix.isEmpty()) return IntArray(0)

    val row = matrix.size
    val col = matrix[0].size
    val d = Array<LinkedList<Int>>(row + col - 1) { LinkedList() }
    for (i in 0 until row) {
        for (j in 0 until col) {
            val key = i + j
            val num = matrix[i][j]
            if (key % 2 == 0) d[key].offerFirst(num)
            else d[key].offer(num)
        }
    }

    val result = IntArray(row * col)
    var index = 0
    for (item in d) {
        for (num in item) {
            result[index] = num
            index++
        }
    }

    return result
}

/*
0,0
0,1
1,0
2,0
1,1
0,2
0,3
1,2
2,1
3,0
 */