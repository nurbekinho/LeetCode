import java.util.*

fun main() {
    println(binarySearch(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
}

fun binarySearch(nums: IntArray, target: Int): Int {
    val index = Arrays.binarySearch(nums, target)
    return if (index < 0) -1 else index
}