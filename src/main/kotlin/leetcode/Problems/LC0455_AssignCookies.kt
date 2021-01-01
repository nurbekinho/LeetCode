fun main() {
    println(findContentChildren(intArrayOf(1, 2, 3), intArrayOf(1, 1)))
    println(findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
    println(findContentChildren(intArrayOf(1, 2, 3), intArrayOf(3)))
}

fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()
    var count = 0
    var j = 0
    for (child in g) {
        if (child <= s[j]) {
            count++
            j++
        } else {
            while (true) {
                j++
                if (j >= s.size) return count
                if (child <= s[j]) {
                    count++
                    j++
                    break
                }
            }
        }

        if (j >= s.size) return count
    }

    return count
}