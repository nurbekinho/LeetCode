fun main() {
    println(intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).contentToString())
    println(intersection(intArrayOf(4, 9, 2), intArrayOf(9, 4, 9, 8, 4)).contentToString())
}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val intersections = mutableSetOf<Int>()
    val set1 = nums1.toSet()
    for (n in nums2) {
        if (set1.contains(n)) intersections.add(n)
    }

    return intersections.toIntArray()
}