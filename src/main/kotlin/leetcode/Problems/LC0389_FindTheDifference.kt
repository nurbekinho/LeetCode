fun main() {
    println(findTheDifference("abcd", "abcde"))
}

fun findTheDifference(s: String, t: String): Char {
    val sMap = s.toCharArray().toList().groupingBy { it }.eachCount()
    return t.toCharArray().toList().groupingBy { it }.eachCount()
        .filter { element -> sMap[element.key] != element.value }
        .map { (key, _) -> key }[0]
}