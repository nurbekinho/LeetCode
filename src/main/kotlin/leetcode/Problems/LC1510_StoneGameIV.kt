import kotlin.math.sqrt

fun main() {
    println(winnerSquareGame(7))
    println(winnerSquareGame(17))
}

fun winnerSquareGame(n: Int): Boolean {
    val dp = BooleanArray(n + 1)
    for (i in 1..n) {
        for (j in 1..sqrt(i.toDouble()).toInt()) {
            if (!dp[i - j * j]) {
                dp[i] = true
                break
            }
        }
    }

    return dp[n]
}