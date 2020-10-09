fun main() {
    println(readBinaryWatch(1))
}

fun readBinaryWatch(num: Int): List<String> {
    val result = mutableListOf<String>()
    for (h in 0..11) {
        for (m in 0..59) {
            if (Integer.bitCount(h) + Integer.bitCount(m) == num) result.add("$h:${if (m < 10) "0" else ""}$m")
        }
    }

    return result
}