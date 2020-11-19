import java.util.*

fun main() {
    //println(decodeString("3[a]2[bc]"))
    //println(decodeString("abc3[cd]xyz"))
    println(decodeString("3[a2[c]]"))
    println(decodeString("3[a10[c]]"))
}

fun decodeString(s: String): String {
    val result = StringBuilder()
    val stack = Stack<StringBuilder>()
    val repeatStack = Stack<Int>()
    var i = 0
    while (i < s.length) {
        val c = s[i]
        if (c.isDigit()) {
            val r = StringBuilder()
            while (s[i].isDigit()) {
                r.append(s[i].toString().toInt())
                i++
            }

            repeatStack.push(r.toString().toInt())
            stack.push(StringBuilder())
        } else if (c == ']') {
            val temp = stack.pop().toString().repeat(repeatStack.pop())
            if (stack.size <= 0) result.append(temp)
            else {
                val last = stack.pop()
                last.append(temp)
                stack.push(last)
            }
        } else if (c.isLetter()) {
            if (repeatStack.size <= 0) result.append(c)
            else {
                val temp = stack.pop()
                temp.append(c)
                stack.push(temp)
            }
        }

        i++
    }

    return result.toString()
}