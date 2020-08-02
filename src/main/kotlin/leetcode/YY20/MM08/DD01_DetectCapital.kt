fun main() {
    println(detectCapitalUse("Nurbek"))
    println(detectCapitalUse("nurbek"))
    println(detectCapitalUse("NURBEK"))
    println(detectCapitalUse("nurBek"))
}

fun detectCapitalUse(word: String): Boolean {
    val lower = word.trim().toLowerCase()
    return word == lower || word == lower.toUpperCase() || word == (lower[0].toUpperCase() + lower.substring(1))
}