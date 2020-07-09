fun main() {
    println(singleNumber2(intArrayOf(2, 2, 3, 2)))
    println(singleNumber2(intArrayOf(0, 1, 0, 1, 0, 1, 99)))
}

fun singleNumber2(nums: IntArray): Int {
    return nums.map { it.toString() }.groupingBy { it }.eachCount().filter { it.value == 1 }.keys.toList()[0].toInt()
}
