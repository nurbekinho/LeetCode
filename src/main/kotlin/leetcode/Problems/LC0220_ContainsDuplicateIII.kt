import java.util.*

fun main() {

}

fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
    val set = TreeSet<Int>()
    for (i in nums.indices) {
        val current = nums[i]
        if (set.floor(current) != null && current <= set.floor(current)!! + t) return true
        if (set.ceiling(current) != null && current >= set.ceiling(current)!! - t) return true

        set.add(current)
        if (i >= k) set.remove(nums[i - k])
    }

    return false
}