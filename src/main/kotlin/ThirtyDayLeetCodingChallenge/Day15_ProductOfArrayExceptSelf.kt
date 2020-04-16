fun main() {
    println(productExceptSelf(intArrayOf(1, 2, 3, 4))!!.contentToString())
    println(productExceptSelf(intArrayOf(2, 2, 5, 3, 4))!!.contentToString())
}

fun productExceptSelf(nums: IntArray): IntArray? {
    val result = IntArray(nums.size)
    for (i in nums.indices) result[i] = if (i == 0) 1 else nums[i - 1] * result[i - 1]

    var temp = 1
    for (i in nums.indices.reversed()) result[i] *= temp.also { temp *= nums[i] }

    return result
}
