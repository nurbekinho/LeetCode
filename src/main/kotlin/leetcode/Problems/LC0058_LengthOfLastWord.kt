fun main() {
    println(lengthOfLastWord("asdf"))
    println(lengthOfLastWord("a "))
    println(lengthOfLastWord("asdf asdf"))
}

fun lengthOfLastWord(s: String): Int {
    val a = s.trim().split(" ")

    return if (a.isEmpty()) 0
    else a[a.size - 1].length
}