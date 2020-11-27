fun main() {
    println(majorityElementII(intArrayOf(1, 1, 1, 3, 3, 2, 2, 2)))
}

fun majorityElementII(nums: IntArray) = nums.toList()
        .groupingBy { it }.eachCount()
        .filter { it.value > nums.size.toFloat().div(3) }
        .map { it.key }
