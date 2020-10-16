import kotlin.math.min

fun main() {
    println(intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).contentToString())
    println(intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).contentToString())
    println(intersect(intArrayOf(4, 4, 4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).contentToString())
}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val m1 = nums1.toList().groupingBy { it }.eachCount()
    val m2 = nums2.toList().groupingBy { it }.eachCount()
    val s = m1.filter { m2.containsKey(it.key) }.toMutableMap()
    val result = mutableListOf<Int>()
    for ((k, v) in s) {
        repeat(min(m1.getValue(k), m2.getValue(k))) {
            result.add(k)
        }
    }

    return result.toIntArray()
}