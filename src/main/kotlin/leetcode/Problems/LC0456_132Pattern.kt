import java.util.*

fun main() {

}

fun find132pattern(nums: IntArray): Boolean {
    val stack = Stack<Int>()
    var middle = Int.MIN_VALUE
    for (i in nums.size - 1 downTo 0) {
        if (nums[i] < middle) return true
        while (!stack.isEmpty() && nums[i] > stack.peek()) middle = stack.pop()
        stack.push(nums[i])
    }

    return false
}