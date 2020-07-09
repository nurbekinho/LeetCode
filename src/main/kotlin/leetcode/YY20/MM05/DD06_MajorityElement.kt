fun main() {
    println(majorityElement(intArrayOf(3,2,3)))
    println(majorityElement(intArrayOf(2,2,1,1,1,2,2)))
}

fun majorityElement(nums: IntArray): Int {
    return nums.filter { num -> nums.count { num == it } > nums.size / 2 }.toList()[0]
}
