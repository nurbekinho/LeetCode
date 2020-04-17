import java.util.*

fun main() {
    println(checkValidString("()"))
    println(checkValidString("(*)"))
    println(checkValidString("(*))"))
    println(checkValidString("))*((((**)*))"))
}

fun checkValidString(s: String): Boolean {
    val leftStack = Stack<Char>()
    for (c in s.toCharArray()) {
        if (c == '(' || c == '*') leftStack.push(c) else if (!leftStack.isEmpty()) leftStack.pop() else return false
    }

    val rightStack = Stack<Char>()
    for (c in s.reversed().toCharArray()) {
        if (c == ')' || c == '*') rightStack.push(c) else if (!rightStack.isEmpty()) rightStack.pop() else return false
    }

    return true
}
