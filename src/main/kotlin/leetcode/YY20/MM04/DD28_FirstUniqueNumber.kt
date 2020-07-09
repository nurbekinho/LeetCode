import java.util.*
import kotlin.collections.HashMap

fun main() {
    var firstUnique = FirstUnique(intArrayOf(2, 3, 5))
    println(firstUnique.showFirstUnique()) // return 2
    firstUnique.add(5) // the queue is now [2,3,5,5]
    println(firstUnique.showFirstUnique()) // return 2
    firstUnique.add(2) // the queue is now [2,3,5,5,2]
    println(firstUnique.showFirstUnique()) // return 3
    firstUnique.add(3) // the queue is now [2,3,5,5,2,3]
    println(firstUnique.showFirstUnique()) // return -1

    firstUnique = FirstUnique(intArrayOf(7, 7, 7, 7, 7, 7))
    println(firstUnique.showFirstUnique()) // return -1
    firstUnique.add(7) // the queue is now [7,7,7,7,7,7,7]
    firstUnique.add(3) // the queue is now [7,7,7,7,7,7,7,3]
    firstUnique.add(3) // the queue is now [7,7,7,7,7,7,7,3,3]
    firstUnique.add(7) // the queue is now [7,7,7,7,7,7,7,3,3,7]
    firstUnique.add(17) // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
    println(firstUnique.showFirstUnique()) // return 17

    firstUnique = FirstUnique(intArrayOf(809))
    println(firstUnique.showFirstUnique()) // return 809
    firstUnique.add(809) // the queue is now [809,809]
    println(firstUnique.showFirstUnique()) // return -1
}

class FirstUnique(nums: IntArray) {
    private var queue: Queue<Int> = LinkedList()
    private var map: HashMap<Int, Int> = HashMap()

    init {
        for (n in nums) {
            queue.add(n)
            map[n] = if (map.containsKey(n)) map[n]!!.plus(1) else 1
        }
    }

    fun showFirstUnique(): Int {
        if (queue.size <= 0) return -1
        if (map[queue.peek()]!! > 1) {
            queue.poll()
            return showFirstUnique()
        }

        return queue.peek()
    }

    fun add(value: Int) {
        map[value] = if (map.containsKey(value)) map[value]!!.plus(1) else 1
        if (map[value]!! <= 1) queue.add(value)
    }
}
