fun main() {
    println(reverseWords("the sky is blue"))
    println(reverseWords("  hello world!  "))
}

fun reverseWords(s: String): String {
    return s.split(" ").filter { it.isNotBlank() }.reversed().joinToString(" ")
}
