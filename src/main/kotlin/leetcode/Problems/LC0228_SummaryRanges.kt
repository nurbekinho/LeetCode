fun main() {

}

fun summaryRanges(nums: IntArray): List<String> {
    val result = mutableListOf<String>()
    var i = 0
    while (i < nums.size) {
        val sb = StringBuilder()
        val start = nums[i]
        sb.append(start)
        while (i != nums.size - 1 && (nums[i + 1] - nums[i] == 1)) i++

        if (nums[i] != start) sb.append("->").append(nums[i])
        result.add(sb.toString())

        i++
    }

    return result
}