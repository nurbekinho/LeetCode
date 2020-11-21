fun main() {
    println(uniqueMorseRepresentations(arrayOf("abc")))
    println(uniqueMorseRepresentations(arrayOf("gin", "zen", "gig", "msg")))
}

fun uniqueMorseRepresentations(words: Array<String>): Int {
    val morse = arrayOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
    return words.map { it.toCharArray().joinToString("") { c -> morse[c - 'a'] } }.toSet().size
}