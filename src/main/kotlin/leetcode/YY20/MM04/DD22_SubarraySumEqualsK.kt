import java.util.*

fun main() {
    println(subarraySum(intArrayOf(1, 1, 1), 2))
}

fun subarraySum(nums: IntArray, k: Int): Int {
    var count = 0

    val sums = IntArray(nums.size)
    for (i in sums.indices) {
        sums[i] += nums[i] + if (i == 0) 0 else sums[i - 1]
    }

    val map: MutableMap<Int, Int> = HashMap()
    for (sum in sums) {
        if (sum == k) count++
        if (map.containsKey(sum - k)) count += map[sum - k]!!
        map[sum] = if (map.containsKey(sum)) map[sum]!! + 1 else 1
    }

    return count
}
