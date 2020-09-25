fun main() {
    println(largestNumber(intArrayOf(3, 30, 34, 5, 9)))
}

fun largestNumber(nums: IntArray): String {
    val result = nums
        .map { it.toString() }
        //.sortedWith { o1, o2 -> (o1.plus(o2).compareTo(o2.plus(o1))) }
        .sortedWith(Comparator { o1, o2 -> (o1.plus(o2).compareTo(o2.plus(o1))) })
        .reversed()
        .joinToString("")

    return if (result[0] == '0') "0" else result
}