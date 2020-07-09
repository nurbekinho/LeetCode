import java.util.*

fun main() {
    println(getPermutation(3, 3))
    println(getPermutation(4, 9))
}

fun getPermutation(n: Int, k: Int): String {
    val list = LinkedList<Int>()
    var t = k
    var num = 1
    for (i in 1..n) {
        num *= i
        list.add(i)
    }

    val sb = StringBuilder(n)
    for (i in n downTo 1) {
        num /= i
        var j = (t - 1) / num
        if (j >= list.size) j = list.size - 1
        sb.append(list[j])
        list.removeAt(j)
        t -= j * num
    }

    return sb.toString()
}
