package leetcode.YY20.MM09;

public class DD01_LargestTimeForGivenDigits {
    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    }

    public static String largestTimeFromDigits(int[] A) {
        String maxTime = "";
        int max = -1;
        for (int h1 = 0; h1 < 4; h1++) {
            for (int h2 = 0; h2 < 4; h2++) {
                for (int m1 = 0; m1 < 4; m1++) {
                    for (int m2 = 0; m2 < 4; m2++) {
                        if (h1 != h2 && h1 != m1 && h1 != m2 && h2 != m1 && h2 != m2 && m1 != m2) {
                            String hour = A[h1]+""+A[h2];
                            String minute = A[m1]+""+A[m2];
                            String current = hour + minute;

                            if (Integer.parseInt(hour) <= 23 && Integer.parseInt(minute) <= 59 && Integer.parseInt(current) > max) {
                                maxTime = hour + ":" + minute;
                                max = Integer.parseInt(current);
                            }
                        }
                    }
                }
            }
        }

        return maxTime;
    }
}
