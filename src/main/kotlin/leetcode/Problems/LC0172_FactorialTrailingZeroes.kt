fun main() {
    println(trailingZeroes(5))
    println(trailingZeroes(1808548329))
}

fun trailingZeroes(n: Int): Int {
    return if (n > 0) trailingZeroes(n / 5) + n / 5 else 0
}