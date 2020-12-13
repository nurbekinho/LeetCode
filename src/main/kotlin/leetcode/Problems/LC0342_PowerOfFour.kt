fun main() {
    println(isPowerOfFour(16))
    println(isPowerOfFour(5))
    println(isPowerOfFour(-2147483648))
    println(isPowerOfFour(1))
    println(isPowerOfFour(2))
    println(isPowerOfFour(3))
}

fun isPowerOfFour(num: Int): Boolean {
    val s = num.toString(2)
    return num > 0 && s.count { it == '1' } == 1 && s.count { it == '0' } % 2 == 0
    //return log10(num.toDouble()) / log10(4.0) % 1 == 0.0
}