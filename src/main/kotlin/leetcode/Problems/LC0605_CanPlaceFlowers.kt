fun main() {
    println(canPlaceFlowers(intArrayOf(1,0,0,0,1), 1))
    println(canPlaceFlowers(intArrayOf(1,0,0,0,1), 2))
    println(canPlaceFlowers(intArrayOf(0,1,0,0,0,1), 2))
    println(canPlaceFlowers(intArrayOf(0,0,1,0,0,0,1), 2))
    println(canPlaceFlowers(intArrayOf(1,0,0,0,1,0,0), 2))
}

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    if (n == 0) return true

    var total = n
    for (i in (if (flowerbed[0] == 0) 0 else 1) until flowerbed.size) {
        val left = if (i - 1 >= 0) flowerbed[i - 1] else 0
        val right = if (i + 1 <= flowerbed.size - 1) flowerbed[i + 1] else 0
        if (flowerbed[i] == 0 && left == 0 && right == 0) {
            total--
            flowerbed[i] = 1
        }
        if (total <= 0) return true
    }

    return false
}