import kotlin.math.sqrt

fun main() {
    println(constructRectangle(4).contentToString())
    println(constructRectangle(37).contentToString())
    println(constructRectangle(122113).contentToString())
}

fun constructRectangle(area: Int): IntArray {
    var width = sqrt(area.toDouble()).toInt()
    while (area % width != 0) width--
    return intArrayOf(area / width, width)
}