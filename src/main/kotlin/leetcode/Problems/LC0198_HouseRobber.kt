import kotlin.math.max

fun main() {
    println(rob(intArrayOf(2, 1)))
    println(rob(intArrayOf(1, 3, 1)))
    println(rob(intArrayOf(2, 1, 1, 2)))
}

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums.first()
    if (nums.size == 2) return max(nums.first(), nums.last())

    val dp = IntArray(nums.size)
    dp[0] = nums[0]
    dp[1] = max(nums[1], dp[0])
    for (i in 2 until nums.size) dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])

    return dp.last()
}