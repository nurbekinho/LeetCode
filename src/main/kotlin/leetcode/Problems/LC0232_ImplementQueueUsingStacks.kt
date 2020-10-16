import java.util.*

fun main() {

}

class MyQueue() {
    /** Initialize your data structure here. */
    val stack = Stack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        stack.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        val firstElement = stack[0]
        stack.removeAt(0)
        return firstElement
    }

    /** Get the front element. */
    fun peek(): Int = stack[0]

    /** Returns whether the queue is empty. */
    fun empty(): Boolean = stack.isEmpty()
}