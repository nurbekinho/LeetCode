import java.util.*

fun main() {
    println(findMaxLength(intArrayOf(0, 1)))
    println(findMaxLength(intArrayOf(0, 1, 0)))
    println(findMaxLength(intArrayOf(0, 1, 0, 0, 0, 0, 1, 0, 0, 1)))
}

fun findMaxLength(nums: IntArray): Int {
    var zeros = Arrays.stream(nums).filter { number: Int -> number == 0 }.count().toInt()
    var ones = nums.size - zeros

    return if (zeros == ones) nums.size else if (zeros == nums.size || ones == nums.size) 0 else {
        zeros = 0
        ones = 0
        var max = 0
        val memo: MutableMap<Int, Int> = HashMap()
        memo[0] = -1
        for (i in nums.indices) {
            if (nums[i] == 0) zeros++
            else ones++

            if (memo.containsKey(zeros - ones)) max = Math.max(max, i - memo[zeros - ones]!!)
            else memo[zeros - ones] = i
        }
        max
    }
}
