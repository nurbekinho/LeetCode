import kotlin.math.min

fun main() {

}

fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    if (timeSeries.isEmpty()) return 0

    var total = 0
    for (i in 1 until timeSeries.size) total += min(duration, timeSeries[i] - timeSeries[i - 1])

    return total + duration
}