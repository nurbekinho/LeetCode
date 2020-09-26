fun main() {

}

fun countPrimes(n: Int): Int {
    val primes = BooleanArray(n)
    for (i in 2 until n) primes[i] = true
    var p = 2
    while (p * p < n) {
        if (primes[p]) {
            var i = p * p
            while (i < n) {
                primes[i] = false
                i += p
            }
        }
        p++
    }
    var count = 0
    for (prime in primes) if (prime) count++
    return count
}