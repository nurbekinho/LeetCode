import java.util.*
import kotlin.collections.HashMap

fun main() {
    println(wordBreak("pineapplepenapple", listOf("apple", "pen", "applepen", "pine", "pineapple")))
}

fun wordBreak(s: String, wordDict: List<String>): List<String> {
    return getResultRecursively(s, wordDict, hashMapOf())
}

fun getResultRecursively(s: String, dict: List<String>, map: HashMap<String, LinkedList<String>>): List<String> {
    if (map.containsKey(s)) return map[s]!!

    val result = LinkedList<String>()
    if (s.isEmpty()) return result.apply { add("") }

    for (word in dict) {
        if (s.startsWith(word)) {
            getResultRecursively(s.substring(word.length), dict, map)
                .forEach { subWord -> result.add("$word${if (subWord.isEmpty()) "" else " "}$subWord") }
        }
    }

    map[s] = result

    return result
}