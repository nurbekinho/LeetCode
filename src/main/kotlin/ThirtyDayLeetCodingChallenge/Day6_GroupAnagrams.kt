fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val dict = mutableMapOf<String, ArrayList<String>>()
    for (str in strs) {
        val sorted = str.toCharArray().sorted().joinToString("")
        if (!dict.containsKey(sorted)) dict[sorted] = ArrayList()
        dict[sorted]!!.add(str)
    }

    return dict.values.toList()
}
