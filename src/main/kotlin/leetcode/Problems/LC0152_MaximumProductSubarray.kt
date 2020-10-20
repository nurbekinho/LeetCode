import kotlin.math.max
import kotlin.math.min

fun main() {
    println(maxProduct(intArrayOf(2, 3, -2, 4)))
    println(maxProduct(intArrayOf(-2, 0, -1)))
}

fun maxProduct(nums: IntArray): Int {
    var max = nums[0]
    var min = nums[0]
    var maxProd = nums[0]

    for (i in 1 until nums.size) {
        val current = nums[i]
        val maxP = max * current
        val minP = min * current
        max = max(current, max(maxP, minP))
        min = min(current, min(maxP, minP))
        maxProd = max(max, maxProd)
    }

    return maxProd
}