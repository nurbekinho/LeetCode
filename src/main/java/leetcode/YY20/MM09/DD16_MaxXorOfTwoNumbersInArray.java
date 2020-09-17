package leetcode.YY20.MM09;

import java.util.HashSet;

public class DD16_MaxXorOfTwoNumbersInArray {
    public static void main(String[] args) {

    }

    public int findMaximumXOR(int[] nums) {
        int result = 0;
        int m = 0;
        for (int i = 31; i >= 0; i--) {
            m |= (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for (int n : nums) set.add(n & m);

            int temp = result | (1 << i);
            for (int s : set) {
                if (set.contains(s ^ temp)) {
                    result = temp;
                    break;
                }
            }
        }

        return result;
    }
}
