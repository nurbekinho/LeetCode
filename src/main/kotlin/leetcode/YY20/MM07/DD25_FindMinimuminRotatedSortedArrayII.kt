fun main() {
    println(findMin(intArrayOf(1, 2, 3)))
    println(findMin(intArrayOf(2, 2, 2, 0, 1)))
}

fun findMin(nums: IntArray) = nums.min()!!