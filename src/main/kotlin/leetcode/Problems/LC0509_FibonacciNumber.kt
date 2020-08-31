fun main() {
    println(fib(0))
    println(fib(1))
    println(fib(2))
    println(fib(3))
    println(fib(4))
}

fun fib(N: Int): Int {
    val fibonacci = IntArray(31).also { it[1] = 1 }
    for (i in 2..30) fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]

    return fibonacci[N]
}