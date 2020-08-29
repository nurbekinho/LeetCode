fun main() {
    val map = mutableMapOf<Int, Int>()
    for (i in 1..100000) {
        val r = rand10()
        map[r] = if (map.containsKey(r)) map[r]!!.plus(1) else 1
        //if (r < 1 || r > 10) println("ERROR")
    }

    println(map.toSortedMap())
}

fun rand10(): Int {
    //return rand7() + rand7() / 2
    var random = 0
    for (i in 0 until 10) random += rand7()
    return random % 10 + 1
}

fun rand7(): Int {
    return listOf(1, 2, 3, 4, 5, 6, 7).shuffled().first()
}