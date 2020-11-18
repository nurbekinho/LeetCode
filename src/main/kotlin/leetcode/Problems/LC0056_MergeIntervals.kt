import kotlin.math.max

fun main() {

}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return emptyArray()

    intervals.sortWith(compareBy { it[0] })
    val result = mutableListOf<IntArray>()
    var i = 0
    var id = 0
    var current = intervals[0]
    while (i < intervals.size) {
        while (i < intervals.size && intervals[i][0] <= current[1]) {
            current[1] = max(current[1], intervals[i++][1])
        }
        result.add(current)
        current = if (i < intervals.size) intervals[i] else intArrayOf()
    }

    return result.toTypedArray()
}