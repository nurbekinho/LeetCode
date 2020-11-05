import kotlin.math.min

fun main() {

}

fun minCostToMoveChips(position: IntArray): Int {
    val temp = intArrayOf(0, 0)
    for (p in position) temp[p % 2]++
    return min(temp[0], temp[1])
}