import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.log

fun main() {
    println(isPowerOfThree(27))
    println(isPowerOfThree(0))
    println(isPowerOfThree(1))
    println(isPowerOfThree(9))
    println(isPowerOfThree(45))
    println(isPowerOfThree(243))
    println(isPowerOfThree(19682))
    println(isPowerOfThree(1594322))
}

fun isPowerOfThree(n: Int) = abs(ceil(log(n.toDouble(), 3.0)) - log(n.toDouble(), 3.0)) < 0.00000000001