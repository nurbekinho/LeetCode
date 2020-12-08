fun main() {
    println(removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)))
}

fun removeDuplicates(nums: IntArray): Int {
    var change = 0
    val twice = 2
    for (n in nums) if (change < twice || n > nums[change - twice]) nums[change++] = n
    return change
}