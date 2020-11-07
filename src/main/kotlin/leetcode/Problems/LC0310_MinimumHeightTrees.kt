fun main() {

}

fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (n == 1) return listOf(0)

    var n = n
    val graph = mutableListOf<MutableSet<Int>>()
    for (i in 0 until n) {
        graph.add(mutableSetOf())
    }

    for (edge in edges) {
        graph[edge[0]].add(edge[1])
        graph[edge[1]].add(edge[0])
    }

    val leafNodes = mutableListOf<Int>()
    for (i in 0 until n) {
        if (graph[i].size == 1) leafNodes.add(i)
    }

    while (n > 2) {
        n -= leafNodes.size
    }

    return emptyList()
}