fun main() {
    println(addDigits(38))
}

fun addDigits(num: Int) = if (num == 0) 0 else 1 + (num - 1) % 9