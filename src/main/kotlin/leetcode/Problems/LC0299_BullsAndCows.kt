import kotlin.math.min

fun main() {
    println(getHint("1807", "7810"))
    println(getHint("1123", "0111"))
}

fun getHint(secret: String, guess: String): String {
    var a = 0
    var b = 0
    val sMap = mutableMapOf<Char, Int>()
    val gMap = mutableMapOf<Char, Int>()

    for (i in secret.indices) {
        val s = secret[i]
        val g = guess[i]
        if (s == g) a++
        else {
            sMap[s] = if (sMap.containsKey(s)) sMap[s]!!.plus(1) else 1
            gMap[g] = if (gMap.containsKey(g)) gMap[g]!!.plus(1) else 1
        }
    }

    for ((k, v) in gMap) {
        if (sMap.containsKey(k)) b += min(sMap[k]!!, v)
    }

    return "${a}A${b}B"
}