fun main() {
    //[1,3,5,7],[10,11,16,20],[23,30,34,50]
    //println(searchMatrix( arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,50)), 3))
    println(searchMatrix(arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,50)), 13))
    println(searchMatrix(arrayOf(intArrayOf()), 13))
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    for (m in matrix) {
        if (m.isNotEmpty() && m.first() <= target && m.last() >= target) return m.filter { it == target }.isNotEmpty()
    }

    return false
}