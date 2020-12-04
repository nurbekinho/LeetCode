fun main() {
    println(selfDividingNumbers(1, 22))
}

fun selfDividingNumbers(left: Int, right: Int): List<Int> {
    return IntRange(left, right).map { if (isSelfDividing(it)) it else -1 }.filter { it > 0 }
}

fun isSelfDividing(n: Int): Boolean {
    for (digit in n.toString().reversed()) {
        val d = digit.toString().toInt()
        if (d == 0 || n % d != 0) return false
    }

    return true
}