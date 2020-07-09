fun main() {
    println(hIndex(intArrayOf(0, 1, 3, 5, 6)))
}

fun hIndex(citations: IntArray): Int {
    val n = citations.size
    var left = 0
    var right = n - 1
    
    while (left <= right) {
        val middle = left + (right - left) / 2
        if (citations[middle] < n - middle) left = middle + 1 else right = middle - 1
    }

    return n - left
}
