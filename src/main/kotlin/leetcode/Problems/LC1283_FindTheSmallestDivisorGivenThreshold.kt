fun main() {

}

fun smallestDivisor(nums: IntArray, threshold: Int): Int {
    var left = 1
    var right = 1000000
    var middle: Int
    var temp: Int

    while (left < right) {
        middle = (left + right) / 2
        temp = 0
        for (n in nums) temp += (n + middle - 1) / middle
        if (temp > threshold) left = middle + 1
        else right = middle
    }
    
    return left
}