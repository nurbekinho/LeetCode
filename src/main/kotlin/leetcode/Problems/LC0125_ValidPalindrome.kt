fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome("0P"))
}

fun isPalindrome(s: String): Boolean {
    val str = s.toCharArray().filter { it.isLetterOrDigit() }.joinToString("").toLowerCase()
    return str == str.reversed()
}