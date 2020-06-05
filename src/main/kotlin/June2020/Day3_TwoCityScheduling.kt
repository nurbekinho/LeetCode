import java.util.*

fun main() {
    println(twoCitySchedCost(arrayOf(
        intArrayOf(10, 20),
        intArrayOf(30, 200),
        intArrayOf(400, 50),
        intArrayOf(30, 20))))
}

fun twoCitySchedCost(costs: Array<IntArray>): Int {
    /*var minCost = 0
    val queue: Queue<Int> = PriorityQueue()

    for (i in costs.indices) {
        minCost += costs[i][0]
        queue.add(costs[i][1] - costs[i][0])
        if (i >= costs.size / 2) minCost += queue.remove()
    }

    return minCost*/

    Arrays.sort(costs, compareBy { it[0] - it[1] })

    var minCost = 0
    for (i in 0 until costs.size / 2) minCost += costs[i][0]
    for (i in costs.size / 2 until costs.size) minCost += costs[i][1]

    return minCost
}
