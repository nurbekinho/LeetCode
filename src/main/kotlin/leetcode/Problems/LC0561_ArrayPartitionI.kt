import kotlin.math.min

fun main() {
    println(arrayPairSum(intArrayOf(1,4,3,2)))
    println(arrayPairSum(intArrayOf(6,2,6,5,1,2)))
}

fun arrayPairSum(nums: IntArray): Int {
    nums.sort()
    return nums
        .mapIndexed { index, i -> if (index % 2 == 0) min(i, nums[index + 1]) else 0 }
        .sum()
}