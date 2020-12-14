fun main() {
    println(findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
}

fun findDuplicates(nums: IntArray) = nums.toList().groupingBy { it }.eachCount().filter { it.value == 2 }.keys.toList()