fun main() {
    println(reverseWordsIII("Let's take LeetCode contest"))
}

fun reverseWordsIII(s: String) = s.split(" ").joinToString(" ") { it.reversed() }