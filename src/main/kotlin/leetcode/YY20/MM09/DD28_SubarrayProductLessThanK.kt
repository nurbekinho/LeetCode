fun main() {

}

fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    var count = 0
    var j = -1
    var product = 1

    for (i in nums.indices) {
        product *= nums[i]
        while (product >= k && j < i) {
            j++
            product /= nums[j];
        }

        count += i - j
    }

    return count
}