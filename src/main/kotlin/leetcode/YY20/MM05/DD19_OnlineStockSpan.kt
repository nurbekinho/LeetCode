import java.util.*

fun main() {
    val spanner = StockSpanner()
    println(spanner.next(100))
    println(spanner.next(80))
    println(spanner.next(60))
    println(spanner.next(70))
    println(spanner.next(60))
    println(spanner.next(75))
    println(spanner.next(85))
}

class StockSpanner() {
    private val stack = Stack<Map<Int, Int>>()

    fun next(price: Int): Int {
        var span = 1
        while (!stack.isEmpty() && price >= stack.peek().keys.toList()[0]) {
            span += stack.pop().values.toList()[0]
        }

        stack.push(mutableMapOf(price to span))
        return span
    }
}
