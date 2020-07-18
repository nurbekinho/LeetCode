import java.util.*

fun main() {
    println(topKFrequent(intArrayOf(1, 1, 1, 1, 2, 2, 3, 4, 4, 4), 2).contentToString())
    println(topKFrequent(intArrayOf(1), 1).contentToString())
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val result = IntArray(k)
    val map = nums.toList().groupingBy { it }.eachCount()
    val queue = PriorityQueue<Int>(kotlin.Comparator { o1, o2 -> map[o1]!! - map[o2]!! })
    for (key in map.keys) {
        queue.add(key)
        if (queue.size > k) queue.poll()
    }

    for (i in 0 until k) {
        result[i] = queue.poll()
    }

    return result
}