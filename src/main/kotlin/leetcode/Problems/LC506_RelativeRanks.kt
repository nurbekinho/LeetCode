fun main() {
    //findRelativeRanks(intArrayOf(5,4,3,2,1)).forEach { println(it) }
    //findRelativeRanks(intArrayOf(10,3,8,9,4)).forEach { println(it) }
    //findRelativeRanks(intArrayOf(1)).forEach { println(it) }
    findRelativeRanks(intArrayOf(123123,11921,1,0,123)).forEach { println(it) }
}

fun findRelativeRanks(score: IntArray): Array<String> {
    val indexed = score.sortedDescending().mapIndexed { index, i -> i to index }.toMap()
    return score.map {
        if (indexed[it] == 0) "Gold Medal"
        else if (indexed[it] == 1) "Silver Medal"
        else if (indexed[it] == 2) "Bronze Medal"
        else indexed[it]?.plus(1).toString()}.toTypedArray()
}