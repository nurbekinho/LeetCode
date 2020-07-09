fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(nums)
    println(nums.contentToString())
}

fun moveZeroes(nums: IntArray) {
    for (i in nums.indices) {
        if (nums[i] == 0) {
            for (j in i + 1 until nums.size) {
                if (nums[j] != 0) {
                    nums[i] = nums[j].also { nums[j] = 0 }
                    break
                }
            }
        }
    }
}
