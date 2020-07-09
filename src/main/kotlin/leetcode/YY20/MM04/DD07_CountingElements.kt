fun main() {
    println(countElements(intArrayOf(1, 2, 3)) == 2)
    println(countElements(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)) == 0)
    println(countElements(intArrayOf(1, 3, 2, 3, 5, 0)) == 3)
    println(countElements(intArrayOf(1, 1, 2, 2)) == 2)
}

fun countElements(arr: IntArray): Int {
    return arr.count { arr.toList().groupingBy { it }.eachCount().containsKey(it + 1) }
}
