fun main() {
    println(backspaceCompare("ab#c", "ad#c"))
    println(backspaceCompare("ab##", "c#d#"))
    println(backspaceCompare("a##c", "#a#c"))
    println(backspaceCompare("a#c", "b"))
}

fun backspaceCompare(S: String, T: String): Boolean {
    var remove = 0
    val ssb = StringBuilder()
    for (i in S.length - 1 downTo 0) {
        when {
            S[i] == '#' -> remove++
            remove > 0 -> remove--
            else -> ssb.append(S[i])
        }
    }

    remove = 0
    val tsb = StringBuilder()
    for (i in T.length - 1 downTo 0) {
        when {
            T[i] == '#' -> remove++
            remove > 0 -> remove--
            else -> tsb.append(T[i])
        }
    }

    return ssb.toString() == tsb.toString()
}
