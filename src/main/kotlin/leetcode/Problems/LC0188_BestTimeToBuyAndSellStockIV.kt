import kotlin.math.min

fun main() {
    println(maxProfit(2, intArrayOf(3, 2, 6, 5, 0, 3)))
}

fun maxProfit(k: Int, prices: IntArray): Int {
    if (prices.size < 2 || k < 1) return 0
    if (k > prices.size / 2) {
        var prof = 0
        for (i in 1 until prices.size) {
            val p = prices[i] - prices[i - 1]
            prof += if (p > 0) p else 0
        }
        return prof
    }

    val minCosts = IntArray(k + 1) { prices[0] }
    val profit = IntArray(k + 1)
    for (price in prices) {
        for (i in 0..k) {
            val temp = if (i == 0) 0 else price - minCosts[i - 1]
            if (temp > profit[i]) profit[i] = temp
            else {
                minCosts[i] = min(price - profit[i], minCosts[i])
            }
        }
    }

    return profit[k]
}

/*

    public int maxProfit(int k, int[] prices) {
        for (int p : prices) {

            for (int t=0; t <= k; ++t) {

                int closingPnl = t == 0 ? 0 : p - minCostOfHolding[t-1];    // If we sell now, our pnl is p - whatever the cost of holding prior to this
                if (closingPnl > profit[t]) {
                    profit[t] = closingPnl;
                } else {
					// if this was a sell, then buying it back will nett to zero, and the minCostOfHolding[t] will be the same, so update here would be a no-op.
					// some solutions assign through profit[t] via Math.max(...) unconditionally, and update minCostOfHolding[t] regardless.
					// That'll work just fine, but I found the if/else construction shaved ~20ms off my time (before adding the special case below).
                    minCostOfHolding[t] = Math.min(p-profit[t], minCostOfHolding[t]);
                }
            }
        }

        return profit[k];
    }
 */