fun main() {

}

fun increasingTriplet(nums: IntArray): Boolean {
    var min = Int.MAX_VALUE
    var mid = Int.MAX_VALUE
    for (n in nums) {
        when {
            n <= min -> min = n
            n <= mid -> mid = n
            else -> return true
        }
    }

    return false
}