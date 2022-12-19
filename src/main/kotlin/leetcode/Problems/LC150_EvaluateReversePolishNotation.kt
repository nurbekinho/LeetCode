package leetcode.problems

import java.util.Stack

fun main() {
    println(evalRPN(arrayOf("2","1","+","3","*")))
    println(evalRPN(arrayOf("4","13","5","/","+")))
}

fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<Int>()
    for (token in tokens) {
        if (token !in setOf("+", "-", "/", "*")) stack.push(token.toInt())
        else {
            val n1 = stack.pop()
            val n2 = stack.pop()
            when (token) {
                "+" -> stack.push(n2 + n1)
                "-" -> stack.push(n2 - n1)
                "/" -> stack.push(n2 / n1)
                "*" -> stack.push(n2 * n1)
            }
        }
    }

    return stack.pop()
}