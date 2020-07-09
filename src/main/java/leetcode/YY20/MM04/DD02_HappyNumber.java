package leetcode.YY20.MM04;

import java.util.HashSet;
import java.util.Set;

public class DD02_HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        if (n <= 1) return true;

        Set<Integer> stats = new HashSet();
        int sum = getSum(n);

        while (true) {
            if (sum == 1) return true;
            if (stats.contains(sum)) break;

            stats.add(sum);
            sum = getSum(sum);
        }

        return false;
    }

    private static int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            int r = n % 10;
            sum += r * r;
            n /= 10;
        }

        return sum;
    }
}
