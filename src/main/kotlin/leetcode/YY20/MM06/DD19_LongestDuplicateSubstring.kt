import java.util.*

fun main() {
    println(longestDupSubstring("banana"))
}

fun longestDupSubstring(S: String): String {
    var left = 1
    var right: Int = S.length
    val mod = Long.MAX_VALUE / 26
    var answer = ""

    while (left <= right) {
        val set = HashSet<Long>()
        val middle = left + (right - left) / 2
        var flag = false
        var hash = 0L
        var p = 1L
        for (i in 0 until middle) {
            hash = (26 * hash + (S[i] - 'a')) % mod
            p = p * 26 % mod
        }
        set.add(hash)

        var i = 0
        while (i + middle < S.length) {
            hash = (hash * 26 + (S[i + middle] - 'a') - (S[i] - 'a') * p) % mod
            if (hash < 0) hash += mod
            if (set.contains(hash)) {
                flag = true
                answer = S.substring(i + 1, i + middle + 1)
                break
            }
            set.add(hash)
            i++
        }

        if (flag) left = middle + 1
        else right = middle - 1
    }

    return answer
}
