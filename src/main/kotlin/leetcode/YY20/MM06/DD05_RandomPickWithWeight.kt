import java.util.Collections
import kotlin.random.Random

fun main() {
    val s = Solution(intArrayOf(1, 2, 3, 4, 5))
}

class Solution(w: IntArray) {
    private var sum = 0
    private var numbers = mutableListOf(0)

    init {
        w.forEach {
            sum += it
            numbers.add(sum)
        }
    }

    fun pickIndex(): Int {
        val index = Collections.binarySearch(numbers, Random.nextInt(sum))
        return if (index >= 0) index else -1 * (index + 2)
    }
}
