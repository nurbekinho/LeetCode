import java.lang.StringBuilder

fun main() {
    println(reverseVowels("hello"))
    println(reverseVowels("leetcode"))
}

fun reverseVowels(s: String): String {
    val reversed = s.toCharArray().filter { it.isVowel() }.reversed()
    val result = StringBuilder()
    var i = 0
    for (c in s) {
        result.append(
            if (c.isVowel()) reversed[i].also { i++ }
            else c
        )
    }
    return result.toString()
}

fun Char.isVowel() = "aeiou".contains(this.toLowerCase())