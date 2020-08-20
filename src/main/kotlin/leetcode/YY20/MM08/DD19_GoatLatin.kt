fun main() {
    println(toGoatLatin("Theb quick brown fox jumped over the lazy dog"))
}

fun toGoatLatin(S: String): String {
    val a = StringBuilder("a")
    return S.split(" ").joinToString(" ") {
        if ("aeiou".contains(it[0].toLowerCase())) (it + "ma" + a).also { a.append("a") }
        else (it.substring(1) + it[0] + "ma" + a).also { a.append("a") }
    }
}