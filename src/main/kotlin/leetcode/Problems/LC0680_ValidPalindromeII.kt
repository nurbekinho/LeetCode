import java.lang.StringBuilder

fun main() {
    println(validPalindrome("abc"))
    println(validPalindrome("abcdef"))
    println(validPalindrome("abcccccca"))
    println(validPalindrome("af"))
}

fun validPalindrome(s: String): Boolean {
    for (i in 0 until s.length / 2) {
        if (s[i] != s[s.length - i - 1]) {
            val first = s.substring(i + 1, s.length - i)
            val last = s.substring(i, s.length - i - 1)
            return first == first.reversed() || last == last.reversed()
        }
    }

    return true
}