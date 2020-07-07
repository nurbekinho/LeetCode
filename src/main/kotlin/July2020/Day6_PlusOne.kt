import java.math.BigInteger

fun main() {
    println(plusOne(intArrayOf(1, 2, 3)).contentToString())
    println(plusOne(intArrayOf(9, 9, 9)).contentToString())
    println(plusOne(intArrayOf(9,8,7,6,5,4,3,2,1,0)).contentToString())
    println(plusOne(intArrayOf(7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6)).contentToString())
}

fun plusOne(digits: IntArray): IntArray {
    return BigInteger(digits.joinToString("")).inc().toString().toCharArray().map { it.toString().toInt() }.toIntArray()
}
