import kotlin.math.max
import kotlin.math.min

fun main() {
    for (a in insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5))) {
        println(a.contentToString())
    }
}

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    var newInterval = newInterval

    for (interval in intervals) {
        if (interval[1] < newInterval[0]) {
            result.add(interval)
        } else if (newInterval[0] < interval[0]) {
            result.add(newInterval)
            newInterval = interval
        } else {
            newInterval[0] = min(newInterval[0], interval[0])
            newInterval[1] = max(newInterval[1], interval[1])
        }
    }

    result.add(newInterval)

    return result.toTypedArray()
}