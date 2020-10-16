fun main() {
    val numArray = NumArray(intArrayOf(1, 2, 3, 4, 5, 6))
    println(numArray.sumRange(0, 2))
}

class NumArray(nums: IntArray) {
    var sum: IntArray = IntArray(nums.size + 1){0}

    init {
        for (i in nums.indices) sum[i + 1] = sum[i] + nums[i]
    }

    fun sumRange(i: Int, j: Int): Int {
        return sum[j + 1] - sum[i]
    }
}