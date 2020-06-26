fun main() {
    println(findDuplicate(intArrayOf(1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println(findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
    println(findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
    println(findDuplicate(intArrayOf(2, 2, 2, 2, 2)))
}

fun findDuplicate(nums: IntArray): Int {
    var slow = nums[0]
    var fast = nums[slow]
    while (slow != fast) {
        slow = nums[slow]
        fast = nums[nums[fast]]
    }

    slow = 0
    while (slow != fast) {
        slow = nums[slow]
        fast = nums[fast]
    }

    return slow
}
