import java.util.*

fun main() {
    var prerequisites = arrayOf(
        intArrayOf(1, 0)
    )
    //println(findOrder(2, prerequisites).contentToString())

    prerequisites = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(2, 0),
        intArrayOf(3, 1),
        intArrayOf(3, 2)
    )
    println(findOrder(4, prerequisites).contentToString())
}

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val courses = IntArray(numCourses)
    for (prerequisite in prerequisites) courses[prerequisite[0]]++

    val stack = Stack<Int>()
    for (i in 0 until numCourses) {
        if (courses[i] == 0) stack.push(i)
    }

    val result = IntArray(numCourses)
    var count = 0
    while (!stack.isEmpty()) {
        val s = stack.pop()
        result[count++] = s

        for (prerequisite in prerequisites) {
            if (prerequisite[1] == s) {
                courses[prerequisite[0]]--
                if (courses[prerequisite[0]] == 0) stack.push(prerequisite[0])
            }
        }
    }

    return if (count == numCourses) result else intArrayOf()
}