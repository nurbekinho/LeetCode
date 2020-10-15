import kotlin.math.max

fun main() {
    println(robII(intArrayOf(2, 3, 2)))
    println(robII(intArrayOf(1, 2, 3, 1)))
}

fun robII(nums: IntArray): Int {
    return when {
        nums.isEmpty() -> 0
        nums.size == 1 -> nums[0]
        nums.size == 2 -> max(nums[0], nums[1])
        else -> max(getMaxRecursively(nums, 0, nums.size - 2), getMaxRecursively(nums, 1, nums.size - 1))
    }
}

fun getMaxRecursively(nums: IntArray, start: Int, end: Int): Int {
    var max = 0
    var temp1 = 0
    var temp2 = 0
    for (i in start..end) {
        temp1 = max
        max = max(nums[i] + temp2, max)
        temp2 = temp1
    }

    return max
}