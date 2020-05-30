lateinit var graph: Array<MutableList<Int>>
lateinit var visited: BooleanArray
lateinit var explored: BooleanArray

fun main() {
    println(canFinish(2, arrayOf(intArrayOf(1, 0))))
    println(canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
}

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    graph = Array(numCourses) { mutableListOf<Int>() }
    for (i in 0 until numCourses) {
        graph[i] = mutableListOf()
    }

    prerequisites.indices.forEach { i ->
        graph[prerequisites[i][0]].add(prerequisites[i][1])
    }

    visited = BooleanArray(numCourses)
    explored = BooleanArray(numCourses)
    for (i in 0 until numCourses) {
        if (!visited[i]) {
            if (cycleExists(i)) {
                return false
            }
        }
    }

    return true
}

fun cycleExists(u: Int): Boolean {
    visited[u] = true

    for (v in graph[u]) {
        if (!visited[v]) {
            if (cycleExists(v)) {
                return true
            }
        } else if (!explored[v]) {
            return true
        }
    }

    explored[u] = true

    return false
}

/*
fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val indegrees = IntArray(numCourses)
        val graph = ArrayList<ArrayList<Int>>()
        //create graph by prerequisites
        for (i in 0 until numCourses) {
            graph.add(ArrayList())
        }

        for (item in prerequisites){
            //graph[item[1]].add(item[0])

            val start = item[1]
            val end = item[0]
            graph[start].add(end)

            indegrees[item[0]]++
        }

        val queue = LinkedList<Int>()
        for (i in 0 until numCourses) {
            if (indegrees[i]==0){
                queue.offer(i)
            }
        }

        while (queue.isNotEmpty()){
            val cur = queue.poll()
            for (item in graph[cur]){
                indegrees[item]--
                if (indegrees[item]==0){
                    queue.offer(item)
                }
            }
        }

        for (i in 0 until numCourses){
            if (indegrees[i]!=0){
                //represent graph got a cycle, so return false
                return false
            }
        }

        return true
    }
 */
