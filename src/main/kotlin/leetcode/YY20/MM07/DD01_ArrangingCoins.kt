fun main() {
    println(arrangeCoins(5))
    println(arrangeCoins(8))
    println(arrangeCoins(10))
}

fun arrangeCoins(n: Int): Int {
    return if (n == 0) 0
    else if (n == 1 || n == 2) 1
    else {
        var m = n
        var i = 1
        while (m - i > i) {
            m -= i
            i++
        }

        i
    }
}
