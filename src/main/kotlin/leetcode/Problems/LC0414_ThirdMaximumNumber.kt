fun main() {
    println(thirdMax(intArrayOf(3, 2, 1)))
    println(thirdMax(intArrayOf(1, 2)))
    println(thirdMax(intArrayOf(2, 2, 3, 1)))
}

fun thirdMax(nums: IntArray): Int {
    val list = nums.toSet().toList().sorted().reversed()
    return if (list.size < 3) list[0] else list[2]
}