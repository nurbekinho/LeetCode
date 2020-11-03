import kotlin.math.max

fun main() {
    println(maxPower("leetcode"))
    println(maxPower("abbcccddddeeeeedcba"))
    println(maxPower("triplepillooooow"))
    println(maxPower("hooraaaaaaaaaaay"))
    println(maxPower("tourist"))
    println(maxPower("touristaaaaaaa"))
    println(maxPower(""))
    println(maxPower("a"))
}

fun maxPower(s: String): Int {
    if (s.isEmpty()) return 0

    var max = 1
    var temp = 1
    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) temp++
        else {
            max = max(max, temp)
            temp = 1
        }
    }

    return max(max, temp)
}