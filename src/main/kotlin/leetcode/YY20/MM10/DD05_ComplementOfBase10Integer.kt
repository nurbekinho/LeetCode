fun main() {
    println(bitwiseComplement(1))
    println(bitwiseComplement(0))
    println(bitwiseComplement(5))
}

fun bitwiseComplement(N: Int): Int {
    return N.toString(2).toCharArray()
        .map { if (it == '1') '0' else '1' }
        .joinToString("").toInt(2)
}