fun main() {
    println(rangeBitwiseAnd(5, 7))
    println(rangeBitwiseAnd(0, 1))
    println(rangeBitwiseAnd(2147483646, 2147483647))
    println(rangeBitwiseAnd(2147483647, 2147483647))
}

fun rangeBitwiseAnd(m: Int, n: Int): Int =
    if (n > m) (rangeBitwiseAnd(m/2, n/2) shl 1) else m
