package leetcode.YY20.MM08;

import java.util.ArrayList;
import java.util.List;

public class DD18_NumbersWithSameConsecutiveDifferences {
    public static void main(String[] args) {

    }

    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 0) return new int[0];
        if (n == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) find(n - 1, k, i, result);


        return result.stream().mapToInt(i -> i).toArray();
    }

    private void find(int n, int k, int num, List<Integer> result) {
        if (n == 0) {
            result.add(num);
            return;
        }

        int last = num % 10;
        if (last + k <=9) find(n - 1, k, num * 10 + (last + k), result);
        if (k != 0 && last - k >= 0) find(n - 1, k, num * 10 + (last - k), result);
    }
}
