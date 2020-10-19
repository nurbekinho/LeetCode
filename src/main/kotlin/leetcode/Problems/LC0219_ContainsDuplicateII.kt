fun main() {
    //[1,2,3,1], k = 3
    println(containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
    println(containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
    println(containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val number = nums[i]
        if (map.containsKey(number) && i - map[number]!! <= k) return true

        map[number] = i
    }

    return false
}