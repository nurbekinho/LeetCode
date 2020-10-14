fun main() {

}

fun buddyStrings(A: String, B: String): Boolean {
    if (A.length != B.length) return false

    if (A == B) {
        val set = mutableSetOf<Char>()
        for (c in A) {
            if (set.contains(c)) return true
            set.add(c)
        }

        return false
    }

    val d = mutableListOf<Int>()
    for (i in A.indices) {
        if (A[i] != B[i]) d.add(i)
    }

    return d.size == 2 && (A[d[0]] == B[d[1]] && B[d[0]] == A[d[1]])
}