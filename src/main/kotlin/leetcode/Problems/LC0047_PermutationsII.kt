fun main() {
    println(permuteUnique(intArrayOf(1, 2, 3)))
}

val result = mutableListOf<List<Int>>()

fun permuteUnique(nums: IntArray): List<List<Int>> {
    traverse(nums.sorted().toList(), listOf())
    return result
}

fun traverse(source: List<Int>, build: List<Int>) {
    if (source.isEmpty()) result.add(build)

    for (i in source.indices) {
        if (i > 0 && source[i] == source[i - 1]) continue

        val tempSource = mutableListOf<Int>()
        tempSource.addAll(source)
        tempSource.removeAt(i)

        val tempBuild = mutableListOf<Int>()
        tempBuild.addAll(build)
        tempBuild.add(source[i])

        traverse(tempSource, tempBuild)
    }
}