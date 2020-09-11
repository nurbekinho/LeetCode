fun main() {
    println(guessNumber(10))
}

fun guessNumber(n: Int): Int {
    var left = 1
    var right = n
    while (left <= right) {
        val middle = left + (right - left) / 2
        val guess = guess(middle)
        when {
            guess < 0 -> right = middle - 1
            guess > 0 -> left = middle + 1
            else -> return middle
        }
    }

    return -1
}

fun guess(n: Int): Int {
    return 6
}