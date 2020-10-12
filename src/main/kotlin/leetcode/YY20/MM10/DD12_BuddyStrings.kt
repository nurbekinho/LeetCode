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

/*
    List<Integer> diff = new ArrayList<>();
    for(int i=0;i<A.length();i++) {
        if(A.charAt(i)!=B.charAt(i))
            diff.add(i);
    }
    return diff.size()==2 && (A.charAt(diff.get(0)) == B.charAt(diff.get(1))  &&
                              B.charAt(diff.get(0)) == A.charAt(diff.get(1)));
 */