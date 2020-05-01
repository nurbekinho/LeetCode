fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) == 7)
    println(maxProfit(intArrayOf(1, 2, 3, 4, 5)) == 4)
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)
}

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) profit += (prices[i] - prices[i - 1])
    }

    return profit
}
