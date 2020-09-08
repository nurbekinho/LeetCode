fun main() {
    println(wordPattern("abba", "dog cat cat dog"))
    println(wordPattern("abba", "dog cat cat fish"))
    println(wordPattern("abba", "dog dog dog dog"))
    println(wordPattern("abc", "dog cat bat"))
}

fun wordPattern(pattern: String, str: String): Boolean {
    val chars = pattern.toCharArray()
    val words = str.split(" ")
    if (chars.size == words.size) {
        val charMap = mutableMapOf<Char, String>()
        val wordMap = mutableMapOf<String, Char>()

        for (i in chars.indices) {
            val currentChar = chars[i]
            val currentWord = words[i]
            if (charMap.containsKey(currentChar) && charMap[currentChar] != currentWord) return false
            if (wordMap.containsKey(currentWord) && wordMap[currentWord] != currentChar) return false

            charMap[currentChar] = currentWord
            wordMap[currentWord] = currentChar
        }

        return true
    }

    return false
}