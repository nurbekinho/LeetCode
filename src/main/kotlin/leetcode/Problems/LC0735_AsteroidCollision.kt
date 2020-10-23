import java.util.*

fun main() {
    //println(asteroidCollision(intArrayOf(5, 10, -5)).contentToString())
    //println(asteroidCollision(intArrayOf(-2, -1, 1, 2)).contentToString())
    //println(asteroidCollision(intArrayOf(10, 2, -5)).contentToString())
    //println(asteroidCollision(intArrayOf(8, -8, 8, -8)).contentToString())
    //println(asteroidCollision(intArrayOf(8, -9, -1)).contentToString())
    //println(asteroidCollision(intArrayOf(8, 8, -9, -1)).contentToString())
    //println(asteroidCollision(intArrayOf(-2, -2, 1, -2)).contentToString())
    println(asteroidCollision(intArrayOf(1, -2, -2, -2)).contentToString())
}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = Stack<Int>()
    for (asteroid in asteroids) {
        if (stack.size > 0 && stack.peek() > 0 && asteroid < 0) {
            while (true) {
                if (stack.size <= 0) {
                    stack.push(asteroid)
                    break
                } else {
                    if (stack.peek() < 0) {
                        stack.push(asteroid)
                        break
                    }
                    val last = stack.pop()
                    if (last + asteroid == 0) {
                        break
                    } else if (last + asteroid > 0) {
                        stack.push(last)
                        break
                    }
                }
            }
        } else {
            stack.push(asteroid)
        }
    }

    return stack.toIntArray()
}