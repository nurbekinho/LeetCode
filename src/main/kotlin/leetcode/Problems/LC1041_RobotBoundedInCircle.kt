fun main() {
    println(isRobotBounded("GGLLGG"))
    println(isRobotBounded("GG"))
    println(isRobotBounded("GL"))
}

fun isRobotBounded(instructions: String): Boolean {
    var x = 0
    var y = 0
    var angle = 90
    for (c in instructions) {
        when (c) {
            'G' -> {
                when (angle) {
                    0 -> x++
                    90 -> y++
                    180 -> x--
                    270 -> y--
                }
            }
            'L' -> angle = (angle + 90) % 360
            else -> angle = (angle - 90) % 360
        }
    }

    return (x == 0 && y == 0) || (angle % 360) != 90
}