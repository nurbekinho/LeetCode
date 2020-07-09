fun main() {
    println(countBits(2).contentToString())
    println(countBits(5).contentToString())
}

fun countBits(num: Int): IntArray {
    val result = IntArray(num + 1)
    for (i in 0..num) {
        var count = 0
        val bs = Integer.toBinaryString(i)

        for (c in bs) {
            if (c == '1') count++
        }

        result[i] = count
    }

    return result
}
