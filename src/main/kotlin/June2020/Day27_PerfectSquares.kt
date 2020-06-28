import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    println(numSquares(12))
    println(numSquares(13))
}

fun numSquares(n: Int): Int {
    val dp = IntArray(n + 1)
    for (i in 1..n) {
        dp[i] = Int.MAX_VALUE
        val max = sqrt(i.toDouble()).toInt()
        if (max * max == i) dp[i] = 1
        else {
            for (j in 1..max) dp[i] = min(dp[i], dp[i - j * j] + 1)
        }
    }

    println(dp.contentToString())

    return dp[n]
}
