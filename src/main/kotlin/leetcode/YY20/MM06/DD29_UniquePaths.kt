fun main() {
    println(uniquePaths(3, 2))
    println(uniquePaths(7, 3))
}

fun uniquePaths(m: Int, n: Int): Int {
    val dp = Array(n) { Array(m) { 1 } }
    for (i in 1 until n) {
        for (j in 1 until m) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }

    return dp[n - 1][m - 1]
}
