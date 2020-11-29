fun main() {
    println(canPartition(intArrayOf(1, 5, 11, 5)))
}

fun canPartition(nums: IntArray): Boolean {
    val dp = mutableSetOf<Int>()
    val sum = nums.sum()
    return if (sum % 2 == 1) false else findRecursively(dp, nums, 0, 0, sum / 2)
}

fun findRecursively(dp: MutableSet<Int>, nums: IntArray, i: Int, currentSum: Int, sum: Int): Boolean {
    if (currentSum == sum) return true
    if (i == nums.size || currentSum > sum || dp.contains(currentSum)) return false
    if (findRecursively(dp, nums, i + 1, currentSum + nums[i], sum) || findRecursively(dp, nums, i + 1, currentSum, sum)) return true
    dp.add(currentSum)

    return false
}