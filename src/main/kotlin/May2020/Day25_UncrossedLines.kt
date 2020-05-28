import kotlin.math.max

fun main() {
    println(maxUncrossedLines(intArrayOf(1, 4, 2), intArrayOf(1, 2, 4)))
    println(maxUncrossedLines(intArrayOf(2, 5, 1, 2, 5), intArrayOf(10, 5, 2, 1, 5, 2)))
    println(maxUncrossedLines(intArrayOf(1, 3, 7, 1, 7, 5), intArrayOf(1, 9, 2, 5, 1)))
    println(maxUncrossedLines(intArrayOf(3, 3), intArrayOf(3)))
}

fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
    val dp = IntArray(B.size + 1)
    for (i in 1..A.size) {
        var previous = 0
        println("----------------------")

        for (j in 1..B.size) {
            val temp = dp[j]
            dp[j] = if (A[i - 1] == B[j - 1]) previous + 1 else max(dp[j], dp[j - 1])
            println(dp.contentToString())
            previous = temp
        }
    }

    return dp[B.size]
}
