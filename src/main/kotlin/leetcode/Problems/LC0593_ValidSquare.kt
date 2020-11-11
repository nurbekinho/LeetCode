import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    //[0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
    println(validSquare(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(0, 1)))
    println(validSquare(intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(0, 0)))
}

fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
    val points = arrayOf(p1, p2, p3, p4)
    val distances = mutableListOf<Double>()
    for (i in 0 until points.size - 1) {
        for (j in i + 1 until points.size) {
            distances.add(sqrt((points[i][0].toDouble() - points[j][0]).pow(2.0) + Math.pow(points[i][1].toDouble() - points[j][1], 2.0)))
        }
    }

    distances.sort()
    if (abs(distances[3] - distances[4]) < 0.1) return false
    for (i in 0 until 5) {
        if (i != 3 && abs(distances[i] - distances[i + 1]) > 0.00001) return false
    }

    return true
}