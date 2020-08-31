fun main() {
    println(findDisappearedNumbers(intArrayOf(1, 2, 2, 3, 3, 4, 7, 8)))
}

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    return (1..nums.size).toList().filter { !nums.contains(it) }
}