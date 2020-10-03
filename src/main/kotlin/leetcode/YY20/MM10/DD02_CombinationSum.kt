fun main() {
    println(combinationSum(intArrayOf(2, 3, 6, 7), 7))
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    findCombinationsRecursively(result, 0, candidates, ArrayList(), target)
    return result
}

fun findCombinationsRecursively(result: ArrayList<List<Int>>, index: Int, candidates: IntArray, combinations: ArrayList<Int>, target: Int) {
    if (target < 0) return
    if (target == 0) {
        val c = ArrayList<Int>()
        c.addAll(combinations)
        result.add(c)
        return
    }

    for (i in index until candidates.size) {
        combinations.add(candidates[i])
        findCombinationsRecursively(result, i, candidates, combinations, target - candidates[i])
        combinations.removeAt(combinations.size - 1)
    }
}
