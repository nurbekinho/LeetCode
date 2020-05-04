fun main() {
    println(canConstruct("a", "b")) //false
    println(canConstruct("aa", "ab")) //false
    println(canConstruct("aa", "aab")) //true
    println(canConstruct("", "a")) //true
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    if (ransomNote.isEmpty()) return true

    val noteMap = ransomNote.filter{ it in ransomNote}
        .groupingBy { it }
        .eachCount()

    val magMap = magazine.filter{ it in magazine}
        .groupingBy { it }
        .eachCount()

    //println(magMap['z'] ?: error("'z' doesn't exists"))

    for ((key, value) in noteMap) {
        if (!magMap.containsKey(key) || magMap[key] ?: error("doesn't exists") < value) return false
    }

    return true
}
