fun main() {
    println(hammingDistance(1, 4))
}

fun hammingDistance(x: Int, y: Int): Int {
    val xBin = x.toBinary(32)
    val yBin = y.toBinary(32)
    var count = 0

    xBin.forEachIndexed {i, c -> if (yBin[i] != c) count++ }

    return count
}

fun Int.toBinary(len: Int): String {
    return String.format("%" + len + "s", this.toString(radix = 2)).replace(" ".toRegex(), "0")
}
