fun main() {
    println(isHappy(19))
}

fun isHappy(n: Int): Boolean {
    if (n <= 1) return true

    val stats = mutableSetOf(n)
    var sum = n.getSum()

    while (!stats.contains(sum)) {
        if (sum == 1) return true

        stats.add(sum)
        sum = sum.getSum()
    }

    return false
}

fun Int.getSum(): Int {
    return this.toString().split("").filter { it.isNotEmpty() }.map { it.toInt() * it.toInt() }.sum()
}
