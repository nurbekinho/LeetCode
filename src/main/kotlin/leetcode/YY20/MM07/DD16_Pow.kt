import kotlin.math.abs

fun main() {
    println(myPow(2.0, 10))
    println(myPow(2.10, 3))
    println(myPow(2.0, -2))
    println(myPow(99.0, -2))
    println(myPow(99.0, 1000))
}

fun myPow(x: Double, n: Int): Double {
    return if (n < 0) 1.0 / pow(x, abs(n)) else pow(x, n)
}

fun pow(x: Double, n: Int): Double {
    if (n == 0) return 1.0
    if (n == 1) return x

    val p = pow(x, n / 2)
    return if (n % 2 == 0) p * p else p * p * x
}