package ThirtyDayLeetCodingChallenge;

public class Day23_BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(0, 1));
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;

        int result = m;

        for (long i = m + 1; i <= n; i++) {
            result = result & (int) i;
            if (result == 0) return 0;
        }

        return result;
    }
}
