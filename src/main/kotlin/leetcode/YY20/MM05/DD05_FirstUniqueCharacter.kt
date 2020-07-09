import java.util.*

fun main() {
    println(firstUniqChar("leetcode"))
    println(firstUniqChar("loveleetcode"))
    println(firstUniqChar(""))
    println(firstUniqChar("aadadaad"))
}

fun firstUniqChar(s: String): Int {
    val queue: Queue<Char> = LinkedList()
    val map = mutableMapOf<Char, Int>()

    s.forEachIndexed { i, c ->
        if (queue.size > 0 && queue.peek() == c) queue.poll()
        else queue.add(c)

        map[c] = (map[c] ?: 0) + 1
    }

    while (true) {
        val c = queue.peek()
        if (queue.size <= 0 || map[c]!! <= 1) break
        else queue.poll()
    }

    return if (queue.size <= 0) -1 else s.indexOf(queue.peek())
}
