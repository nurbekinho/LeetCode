import java.util.*

fun main() {
    val iterator = CombinationIterator("abc", 2)
    println(iterator.next()) // returns "ab"
    println(iterator.hasNext()) // returns true
    println(iterator.next()) // returns "ac"
    println(iterator.hasNext()) // returns true
    println(iterator.next()) // returns "bc"
    println(iterator.hasNext()) // returns false
}

class CombinationIterator(characters: String, combinationLength: Int) {
    val queue: Queue<String> = LinkedList<String>()

    init {
        fillQueue(characters, "", 0, combinationLength, queue)
    }

    private fun fillQueue(characters: String, word: String, index: Int, length: Int, queue: Queue<String>) {
        if (length == 0) {
            queue.add(word)
            return
        }

        for (i in index until characters.length) {
            fillQueue(characters, word + characters[i], i + 1, length - 1, queue)
        }
    }

    fun next() = queue.poll()

    fun hasNext() = !queue.isEmpty()
}
