fun main() {
    println(isIsomorphic("egge", "adda"))
    println(isIsomorphic("egge", "adca"))
}

fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length == t.length) {
        val sMap = mutableMapOf<Char, MutableList<Int>>()
        val tMap = mutableMapOf<Char, MutableList<Int>>()
        for (i in s.indices) {
            val sCh = s[i]
            if (sMap.containsKey(sCh)) sMap[sCh]!!.add(i)
            else sMap[sCh] = mutableListOf(i)

            val tCh = t[i]
            if (tMap.containsKey(tCh)) tMap[tCh]!!.add(i)
            else tMap[tCh] = mutableListOf(i)
        }

        if (sMap.size == tMap.size) {
            val checkedChars = mutableSetOf<Char>()
            for (i in s.indices) {
                val sCh = s[i]
                val tCh = t[i]
                if (!checkedChars.contains(sCh)) {
                    if (sMap[sCh] != tMap[tCh]) return false
                }

                checkedChars.add(sCh)
            }

            return true
        }
    }

    return false
}