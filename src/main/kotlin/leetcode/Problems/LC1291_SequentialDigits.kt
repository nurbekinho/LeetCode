fun main() {
    println(sequentialDigits(100, 300))
    println(sequentialDigits(1000, 13000))
}

fun sequentialDigits(low: Int, high: Int): List<Int> {
    val sequential = mutableListOf<Int>()
    val digits = "123456789"
    for (i in 2..9) {
        for (j in 0 until digits.length - i + 1) {
            sequential.add(digits.substring(j, i + j).toInt())
        }
    }

    return sequential.filter { it in low..high }
}