import java.util.*
import kotlin.math.max

fun main() {
    println(removeCoveredIntervals(arrayOf(intArrayOf(1, 4), intArrayOf(3, 6), intArrayOf(2, 8))))
    println(removeCoveredIntervals(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))))
    println(removeCoveredIntervals(arrayOf(intArrayOf(4, 10), intArrayOf(3, 10), intArrayOf(5, 11))))
}

fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
    Arrays.sort(intervals) { a: IntArray, b: IntArray -> if (a[0] == b[0]) b[1] - a[1] else a[0] - b[0] }
    var count = 0
    var maximum = 0
    for (interval in intervals) {
        if (interval[1] <= maximum) count++
        maximum = max(interval[1], maximum)
    }

    return intervals.size - count
}