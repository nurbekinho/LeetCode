fun main() {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)) == 6)
}

fun maxSubArray(nums: IntArray): Int {
    var max = Int.MIN_VALUE
    var current = 0

    for (i in nums.indices) {
        current += nums[i]
        max = kotlin.math.max(max, current)
        if (current < 0) current = 0
    }

    return max
}
