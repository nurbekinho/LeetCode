fun main() {
    println(wordBreak("leetcode", listOf("leet", "code")))
    println(wordBreak("applepenapple", listOf("apple", "pen")))
    println(wordBreak("applepenapplepencil", listOf("apple", "pen", "pencil")))
}

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val map = mutableMapOf<String, Boolean>()
    return findRecursively(s, wordDict, map)
}

fun findRecursively(s: String, wordDict: List<String>, map: MutableMap<String, Boolean>): Boolean {
    if (s.isEmpty()) return true
    if (map[s] != null) return map[s]!!

    for (word in wordDict) {
        if (s.startsWith(word) && findRecursively(s.substring(word.length), wordDict, map)) {
            map[s.substring(word.length)] = true
            return true
        }
    }

    map[s] = false

    return false
}