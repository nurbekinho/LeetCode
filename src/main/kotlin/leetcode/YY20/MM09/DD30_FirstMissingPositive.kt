import kotlin.math.abs

fun main() {
    println(firstMissingPositive(intArrayOf(1, 2, 0)))
    println(firstMissingPositive(intArrayOf(3, 4, -1, 1)))
    println(firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
}

fun firstMissingPositive(nums: IntArray): Int {
    if (nums.isEmpty()) return 1

    for (i in nums.indices) if (nums[i] <= 0) nums[i] = Int.MAX_VALUE

    for (i in nums.indices) {
        val c = abs(nums[i])
        if (c == 0 || c > nums.size) continue
        if (nums[c - 1] > 0) nums[c - 1] *= -1
    }

    for (i in 1..nums.size) if (nums[i - 1] >= 0) return i

    return nums.size + 1
}