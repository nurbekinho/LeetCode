import java.lang.StringBuilder

fun main() {
    println(repeatedSubstringPattern("ababababab"))
    println(repeatedSubstringPattern("ababababa"))
}

fun repeatedSubstringPattern(s: String): Boolean {
    val length = s.length
    for (i in 1..length / 2) {
        if (length % i == 0) {
            val sub = s.substring(0, i)
            val sb = StringBuilder()
            repeat(length / i) {
                sb.append(sub)
            }

            if (sb.toString() == s) return true
        }
    }

    return false
}