package leetcode.Problems;

public class LC0204_CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(1));
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(3));
        System.out.println(countPrimes(4));
        System.out.println(countPrimes(5));
    }

    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2 ; i < n ; i++) primes[i] = true;

        for (int p = 2 ; p * p < n ; p++) {
            if (primes[p]) {
                for (int i = p * p ; i < n ; i += p) primes[i] = false;
            }
        }

        int count = 0;
        for (boolean prime : primes) if (prime) count++;

        return count;
    }
}
