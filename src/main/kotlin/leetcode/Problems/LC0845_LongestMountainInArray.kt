import kotlin.math.max

fun main() {
    println(longestMountain(intArrayOf(2, 1, 4, 7, 3, 2, 5)))
}

fun longestMountain(A: IntArray): Int {
    var max = 0
    for (i in 1 until A.size - 1) {
        var left = i - 1
        var right = i + 1
        if (A[left] < A[i] && A[i] > A[right]) {
            var length = 1
            while (left > -1 && A[left] < A[left + 1]) {
                length++
                left--
            }
            while (right < A.size && A[right - 1] > A[right]) {
                length++
                right++
            }
            max = max(max, length)
        }
    }

    return max
}