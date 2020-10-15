import kotlin.math.sqrt

fun main() {
    println(checkPerfectNumber(6))
}

fun checkPerfectNumber(num: Int): Boolean {
    var sum = 1
    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) sum += i + num / i
    }

    return num > 1 && sum == num
}