fun main() {
    println(partitionLabels("ababcbacadefegdehijhklij"))
}

fun partitionLabels(S: String): List<Int> {
    val result = mutableListOf<Int>()
    val map = mutableMapOf<Char, Int>()
    for (i in S.indices) map[S[i]] = i

    var maxIndex = 0
    var temp = -1
    for (i in S.indices) {
        if (map[S[i]]!! > maxIndex) maxIndex = map[S[i]]!!
        if (i == maxIndex) result.add(maxIndex - temp).also { temp = maxIndex }
    }

    return result
}