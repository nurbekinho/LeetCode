import kotlin.math.sqrt

fun main() {
    println(isPerfectSquare(16))
    println(isPerfectSquare(14))
}

fun isPerfectSquare(num: Int): Boolean {
    return sqrt(num.toDouble()) - sqrt(num.toDouble()).toInt() == 0.0
}
