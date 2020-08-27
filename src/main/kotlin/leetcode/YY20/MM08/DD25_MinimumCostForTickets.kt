fun main() {
    println(mincostTickets(intArrayOf(1,4,6,7,8,20), intArrayOf(2, 7, 15)))
    println(mincostTickets(intArrayOf(1,2,3,4,5,6,7,8,9,10,30,31), intArrayOf(2, 7, 15)))
}

fun mincostTickets(days: IntArray, costs: IntArray): Int {
    /*val dp = IntArray(days.size + 1)
    var d7 = -1
    var d30 = -1
    for (i in 1..days.size) {
        while (d7 < days.size - 1 && days[d7 + 1] <= days[i - 1] - 7) d7++
        while (d30 < days.size - 1 && days[d30 + 1] <= days[i - 1] - 30) d30++

        dp[i] = min(dp[i - 1] + costs[0], min(dp[d7 + 1] + costs[1], dp[d30 + 1] + costs[2]))
    }

    return dp[dp.size - 1]*/

    val dp = IntArray(366)
    var day = 0
    for (i in 1..dp.lastIndex) {
        dp[i] =
            if (day >= days.size || days[day] != i) dp[i - 1]
            else minOf(dp[i - 1] + costs[0], dp[maxOf(0, i - 7)] + costs[1], dp[maxOf(0, i - 30)] + costs[2]).also { day++ }
    }

    return dp.last()
}