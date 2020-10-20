import kotlin.math.min

fun main() {
    println(minDominoRotations(intArrayOf(2 ,1, 2, 4, 2, 2), intArrayOf(5, 2, 6, 2, 3, 2)))
}

fun minDominoRotations(A: IntArray, B: IntArray): Int {
    val minR1 = getMinRotation(A, B, A[0])
    val minR2 = getMinRotation(A, B, B[0])

    return if (minR1 != -1 && minR2 != -1) min(minR1, minR2)
    else if (minR1 != -1) minR1
    else if (minR2 != -1) minR2
    else -1
}

fun getMinRotation(A: IntArray, B: IntArray, n: Int): Int {
    var minR = 0
    for (i in 1 until A.size) {
        if (n != A[i] && n != B[i]) {
            minR = -1
            break
        }
    }

    if (minR == 0) {
        minR = min(A.size - A.count { it == n }, A.size - B.count { it == n })
    }

    return minR
}