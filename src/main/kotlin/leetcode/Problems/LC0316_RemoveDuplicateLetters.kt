import java.util.*

fun main() {

}

fun removeDuplicateLetters(s: String): String {
    val map = s.toCharArray().toList().groupingBy { it }.eachCount().toMutableMap()
    val used: MutableSet<Char> = HashSet()
    val result = StringBuilder()

    for (i in s.indices) {
        val current = s[i]
        map[current] = map.getOrDefault(current,0) - 1
        if (used.contains(current)) continue

        if (result.isEmpty()) {
            result.append(current)
            used.add(current)
        } else {
            while (result.isNotEmpty() && (result[result.length - 1] > current)) {
                val previous = result[result.length - 1]
                if (map[previous]!! >= 1) {
                    result.deleteCharAt(result.length - 1)
                    used.remove(previous)
                } else break
            }

            result.append(current)
            used.add(current)
        }
    }

    return result.toString()
}