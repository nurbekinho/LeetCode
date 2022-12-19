fun main() {
    println(reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39))
    println(reverseStrShort("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39))
}

fun reverseStr(s: String, k: Int): String {
    if (k >= s.length) return s.reversed()

    val sb = StringBuilder()
    for (i in 0 until s.length / k) {
        val sub = s.substring(i * k, i * k + k)
        sb.append(if (i % 2 == 0) sub.reversed() else sub)
    }

    if (s.length % k != 0) {
        val sub = s.substring(s.length - s.length % k, s.length)
        sb.append(if (s.length / k % 2 == 0) sub.reversed() else sub)
    }

    return sb.toString()
}

fun reverseStrShort(s: String, k: Int): String {
    return s.chunked(k).mapIndexed { index, str -> if (index % 2 == 0) str.reversed() else str }.joinToString("")
}