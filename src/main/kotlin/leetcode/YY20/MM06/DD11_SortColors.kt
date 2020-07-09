fun main() {
    sortColors(intArrayOf())
    sortColors(intArrayOf(0, 0, 0))
    sortColors(intArrayOf(1, 1, 1))
    sortColors(intArrayOf(2, 2, 2))
    sortColors(intArrayOf(1, 2, 0, 0, 2, 1, 0))
    sortColors(intArrayOf(1, 0, 0, 1, 0))
    sortColors(intArrayOf(1, 2, 1, 2, 2, 1, 1))
}

fun sortColors(nums: IntArray) {
    val map = nums.groupBy { it }
    for (i in nums.indices) {
        nums[i] = when {
            map.containsKey(0) && i < map[0]!!.size -> 0
            map.containsKey(1) && i < map[1]!!.size + if (map.containsKey(0)) map[0]!!.size else 0 -> 1
            else -> 2
        }
    }
}
