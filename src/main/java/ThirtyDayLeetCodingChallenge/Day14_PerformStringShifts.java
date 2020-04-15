package ThirtyDayLeetCodingChallenge;

public class Day14_PerformStringShifts {
    public static void main(String[] args) {
        System.out.println(stringShift("abc", new int[][]{
                {0, 1},
                {1, 2}
        }));

        System.out.println(stringShift("abcdefg", new int[][]{
                {1, 1},
                {1, 1},
                {0, 2},
                {1, 3},
                {1, 7}
        }));
    }

    public static String stringShift(String s, int[][] shift) {
        for (int[] operation : shift) {
            int i = (operation[0] == 0) ? operation[1] : s.length() - operation[1];
            s = s.substring(i) + s.substring(0, i);
        }

        return s;
    }
}
