fun main() {
    println(stringShift("abc", arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))))

    println(
        stringShift(
            "abcdefg",
            arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(1, 7))
        )
    )
}

fun stringShift(s: String, shift: Array<IntArray>): String {
    var s = s
    for (operation in shift) {
        val i = if (operation[0] == 0) operation[1] else s.length - operation[1]
        s = s.substring(i) + s.substring(0, i)
    }

    return s
}
