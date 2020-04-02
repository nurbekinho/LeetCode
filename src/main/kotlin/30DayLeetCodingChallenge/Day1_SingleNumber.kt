fun main() {
    println(singleNumber(intArrayOf(2, 2, 1)) == 1)
    println(singleNumber(intArrayOf(4, 1, 2, 1, 2)) == 4)
}

fun singleNumber(nums: IntArray): Int {
    return nums.find {element -> nums.count { element == it } == 1}!!
}
