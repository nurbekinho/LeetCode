import java.util.*

fun main() {
    println(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
}

fun lastStoneWeight(stones: IntArray): Int {
    val queue = PriorityQueue(
        Comparator { e1: Int, e2: Int -> e2 - e1 }
    )
    for (stone in stones) queue.add(stone)

    while (queue.size > 0) {
        if (queue.size == 1) break
        val last = queue.poll()
        val previous = queue.poll()
        if (last != previous) queue.add(last - previous)
    }

    return if (queue.size > 0) queue.poll() else 0
}
