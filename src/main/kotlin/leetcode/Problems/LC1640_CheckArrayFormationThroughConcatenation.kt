fun main() {
    println(canFormArray(intArrayOf(91, 4, 64, 78), arrayOf(
        intArrayOf(78),
        intArrayOf(4, 64),
        intArrayOf(91)
    )))
}

fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
    val map = mutableMapOf<Int, IntArray>()
    for (piece in pieces) map[piece[0]] = piece

    var i = 0
    while (i < arr.size) {
        val current = arr[i]
        if (map.containsKey(current)) {
            val piece = map[current]!!
            for (j in piece.indices) {
                if (arr[i] != piece[j]) return false
                if (j != piece.size - 1) i++
            }
        } else return false

        i++
    }

    return true
}