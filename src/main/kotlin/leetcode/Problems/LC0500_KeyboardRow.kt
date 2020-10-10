fun main() {
    println(findWords(arrayOf("Hello", "Alaska", "Dad", "Peace")).contentToString())
}

fun findWords(words: Array<String>): Array<String> {
    return words
        .filter { it.all { c -> "qwertyuiop".contains(c.toLowerCase()) } ||
                it.all { c -> "asdfghjkl".contains(c.toLowerCase()) } ||
                it.all { c -> "zxcvbnm".contains(c.toLowerCase()) } }
        .toTypedArray()
}

fun isInRow(row: String, word: String): Boolean {
    return row.toCharArray().toSet().union(word.toLowerCase().toCharArray().toSet()).size <= row.length
}