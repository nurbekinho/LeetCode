fun main() {
    //println(mirrorReflection(2, 1))
    //println(mirrorReflection(4, 3))
}

fun mirrorReflection(p: Int, q: Int): Int {
    val gcd = gcd(p, q)
    var p = p / gcd
    p %= 2
    var q = q / gcd
    q %= 2

    return if (p != 1 || q != 1) {
        if (p == 1) 0
        else 2
    } else 1
}

fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)