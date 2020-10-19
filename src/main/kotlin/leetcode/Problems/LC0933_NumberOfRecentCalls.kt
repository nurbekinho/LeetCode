fun main() {

}

class RecentCounter() {
    var requests = IntArray(100001)
    var start = 0
    var end = 0

    fun ping(t: Int): Int {
        requests[end++] = t
        while (start < end && requests[start] < (t - 3000)) start++
        return end - start
    }
}