import kotlin.math.max

fun main() {
    println(canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(canJump(intArrayOf(3, 2, 1, 0, 4)))
}

fun canJump(nums: IntArray): Boolean {
    var currentIndex = 0
    for (i in nums.indices) {
        if (i > currentIndex) return false
        currentIndex = max(i + nums[i], currentIndex)
    }

    return true
}
