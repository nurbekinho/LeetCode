fun main() {
    println(hammingWeight(3))
    println(hammingWeight(-3))
}

fun hammingWeight(n: Int): Int {
    Integer.toBinaryString(n)
    return Integer.toBinaryString(n).count { it == '1' }
}