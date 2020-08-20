fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
}

fun containsDuplicate(nums: IntArray) = nums.toList().groupingBy { it }.eachCount().filter { (_, v) -> v > 1 }.isNotEmpty()