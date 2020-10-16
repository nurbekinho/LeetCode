fun main() {
    println(rotate(intArrayOf(1,2,3,4,5,6,7), 3))
}

fun rotate(nums: IntArray, k: Int) {
    var k = k
    while (k > 0) {
        val temp = IntArray(nums.size)
        temp[0] = nums.last()
        for (i in 1 until nums.size) {
            temp[i] = nums[i - 1]
        }

        for (i in nums.indices) {
            nums[i] = temp[i]
        }

        k--
    }

    println(nums.contentToString())
}