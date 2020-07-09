fun main() {
    println(prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 7).contentToString())
}

fun prisonAfterNDays(cells: IntArray, N: Int): IntArray {
    val n = if (N % 14 == 0) 14 else N % 14
    for (i in 1 until n + 1) {
        var previous = cells[0]
        cells[0] = 0
        for (j in 1..6) {
            val temp = cells[j]
            cells[j] = if (previous == cells[j + 1]) 1 else 0
            previous = temp
        }

        cells[7] = 0
    }

    return cells
}
