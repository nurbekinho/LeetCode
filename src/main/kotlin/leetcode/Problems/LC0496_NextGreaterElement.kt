fun main() {
    println(nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2)).contentToString())
    println(nextGreaterElement(intArrayOf(1,3,5,2,4), intArrayOf(6,5,4,3,2,1,7)).contentToString())
}

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val map2 = nums2.mapIndexed { index, i -> i to index}.toMap()
    for (i in nums1.indices) {
        val current = nums1[i]
        var j = map2[current]!!
        while (j < nums2.size - 1) {
            j++
            if (nums2[j] > current) {
                nums1[i] = nums2[j]
                break
            }
        }

        if (nums1[i] == current) nums1[i] = -1
    }

    return nums1
}