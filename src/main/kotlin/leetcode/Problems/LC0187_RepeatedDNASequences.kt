fun main() {
    println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
}

fun findRepeatedDnaSequences(s: String): List<String> {
    val map = mutableMapOf<String, Int>()
    for (i in 0 until s.length - 9) {
        val dna = s.substring(i, i + 10)
        map[dna] = 1 + map.getOrDefault(dna, 0)
    }

    return map.filter { it.value > 1 }.map { it.key }
}