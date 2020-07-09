import kotlin.math.min

fun main() {
    println(nthUglyNumber(10))
    println(nthUglyNumber(11))
}

fun nthUglyNumber(n: Int): Int {
    val uglyNumbers = mutableListOf(1)
    var two = 0; var three = 0; var five = 0

    for (i in 1..1690) {
        val m = min(min(2 * uglyNumbers[two], 3 * uglyNumbers[three]), 5 * uglyNumbers[five])
        if (m == 2 * uglyNumbers[two]) two++
        if (m == 3 * uglyNumbers[three]) three++
        if (m == 5 * uglyNumbers[five]) five++
        uglyNumbers.add(m)
    }

    return uglyNumbers[n - 1]
}
