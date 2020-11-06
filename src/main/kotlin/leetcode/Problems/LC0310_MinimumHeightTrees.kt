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

/*
if(n == 1) return Collections.singletonList(0);

List<Set<Integer>> graph = new ArrayList();
IntStream.range(0, n)
         .forEach(i -> graph.add(new HashSet()));

Arrays.stream(edges)
     .forEach(edge -> {
         graph.get(edge[0]).add(edge[1]);
         graph.get(edge[1]).add(edge[0]);
     });

List<Integer> leafNodes = IntStream.range(0, n)
                                   .filter(i -> graph.get(i).size() == 1)
                                   .boxed()
                                   .collect(Collectors.toList());

List<Integer> answer = new ArrayList();
while(n > 2) {
    n -= leafNodes.size();
    List<Integer> newLeaves = leafNodes.stream()
                                       .map(leaf -> {
                                           int neigh = graph.get(leaf).iterator().next();
                                           graph.get(neigh).remove(leaf);
                                           return neigh;
                                       })
                                       .filter(neigh -> graph.get(neigh).size() == 1)
                                       .collect(Collectors.toList());
    leafNodes = newLeaves;
}

return leafNodes;
 */