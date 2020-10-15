import java.lang.StringBuilder

fun main() {
    println(toHex(26))
    println(toHex(-1))
}

fun toHex(num: Int): String {
    val h = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f")
    val result = StringBuilder()
    var count = 0
    var num = num
    while (count < 8 && num != 0) {
        result.append(h[num and 15])
        num = num shr 4
        count++
    }

    return result.reverse().toString()
}