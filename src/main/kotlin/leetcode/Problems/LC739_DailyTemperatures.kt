package leetcode.problems

import java.util.*

fun main() {
    println(dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)).joinToString("-"))
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size)
    val stack = Stack<Int>()

    for (i in temperatures.indices) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            val index = stack.pop()
            result[index] = i - index
        }

        stack.push(i)
    }

    return result
}