fun main() {
    println(maxSubarraySumCircular(intArrayOf(1, -2, 3, -2)))
    println(maxSubarraySumCircular(intArrayOf(5, -3, 5)))
    println(maxSubarraySumCircular(intArrayOf(3, -1, 2, -1)))
    println(maxSubarraySumCircular(intArrayOf(3, -2, 2, -3)))
    println(maxSubarraySumCircular(intArrayOf(-2, -3, -1)))
}

fun maxSubarraySumCircular(A: IntArray): Int {
    var tempMin = 0
    var tempMax = 0
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    var sum = 0

    for (i in A.indices) {
        sum += A[i]
        tempMin = if (tempMin > 0) A[i] else tempMin + A[i]
        tempMax = if (tempMax < 0) A[i] else tempMax + A[i]
        min = kotlin.math.min(min, tempMin)
        max = kotlin.math.max(max, tempMax)
    }

    return if (max < 0) max else kotlin.math.max(max, sum - min)
}
