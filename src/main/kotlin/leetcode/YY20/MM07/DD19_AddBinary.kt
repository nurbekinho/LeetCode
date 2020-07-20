import java.math.BigInteger

fun main() {
    println(addBinary("11", "1"))
}

fun addBinary(a: String, b: String): String = BigInteger(a, 2).add(BigInteger(b, 2)).toString(2)