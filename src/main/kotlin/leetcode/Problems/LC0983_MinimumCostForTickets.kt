fun main() {
    println(mincostTickets(intArrayOf(1,4,6,7,8,20), intArrayOf(2, 7, 15)))
    println(mincostTickets(intArrayOf(1,2,3,4,5,6,7,8,9,10,30,31), intArrayOf(2, 7, 15)))
}

fun mincostTickets(days: IntArray, costs: IntArray): Int {
    val dp = IntArray(366)
    var day = 0
    for (i in 1..dp.lastIndex) {
        dp[i] =
            if (day >= days.size || days[day] != i) dp[i - 1]
            else minOf(dp[i - 1] + costs[0], dp[maxOf(0, i - 7)] + costs[1], dp[maxOf(0, i - 30)] + costs[2]).also { day++ }
    }

    return dp.last()
}