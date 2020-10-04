fun main() {

}

fun findPairs(nums: IntArray, k: Int): Int {
    val map = mutableMapOf<Int, Int>()
    for (n in nums) map[n] = map.getOrDefault(n, 0) + 1

    var count = 0
    for (key in map.keys) {
        if (map.containsKey(key + k) && ((k == 0 && map[key]!! >= 2) || k != 0)) count++
    }

    return count
}