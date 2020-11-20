fun main() {
    println(findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1)))
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    println(nums.joinToString("").split("0").sortedBy { it.length }.last().length)
    return 1
}