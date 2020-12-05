fun main() {

}

fun smallestRepunitDivByK(K: Int): Int {
    if (K % 2 == 0 || K % 5 == 0) return -1
    var n = 0
    for (i in 1 until K + 1) {
        n = (n * 10 + 1) % K
        if (n == 0) return i
    }

    return -1
}