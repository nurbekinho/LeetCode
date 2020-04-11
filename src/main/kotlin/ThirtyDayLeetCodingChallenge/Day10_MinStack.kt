import java.util.*

fun main() {
    val stack = MinStack()
    stack.push(-2)
    stack.push(0)
    stack.push(-3)
    println(stack.getMin())
    stack.pop()
    println(stack.top())
    println(stack.getMin())
}

internal class MinStack {
    var data: MutableList<Int> = ArrayList()
    var stack: Stack<Int> = Stack()

    fun push(x: Int) {
        if (stack.isEmpty() || x <= stack.peek()) stack.push(x)
        data.add(x)
    }

    fun pop() {
        val removed = data.removeAt(data.size - 1)
        if (stack.peek() == removed) stack.pop()
    }

    fun top(): Int = data[data.size - 1]

    fun getMin(): Int = stack.peek()
}
