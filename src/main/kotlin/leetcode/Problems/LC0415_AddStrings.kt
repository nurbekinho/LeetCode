import java.lang.Exception
import java.lang.StringBuilder
import kotlin.math.max

fun main() {
    println(addStrings("1234", "12345")) // 13579
    println(addStrings("87777", "12345")) // 100122
    println(addStrings("0", "0")) // 0
    println(addStrings("5", "5")) // 10
    println(addStrings("9", "9")) // 10
    println(addStrings("99", "99")) // 10
}

fun addStrings(num1: String, num2: String): String {
    val result = StringBuilder()
    var r = 0
    for (i in 0 until max(num1.length, num2.length)) {
        val n1 = try { num1[num1.length - i - 1].toString().toInt() } catch (e: Exception) { 0 }
        val n2 = try { num2[num2.length - i - 1].toString().toInt() } catch (e: Exception) { 0 }
        val sum = n1 + n2 + r
        if (sum >= 10) {
            r = 1
            result.append(sum % 10)
        } else {
            result.append(sum)
            r = 0
        }
    }

    return if (r == 1) "1".plus(result.reverse().toString()) else result.reverse().toString()
}