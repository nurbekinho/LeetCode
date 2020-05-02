package May2020;

public class Day1_FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        long left = 0;
        long right = n;
        long version = 0;
        while (left <= right) {
            long middle = (left + right) / 2;
            if (isBadVersion((int) middle)) {
                right = middle - 1;
                version = middle;
            } else left = middle + 1;
        }

        return (int) version;
    }

    private static boolean isBadVersion(int version) {
        return version == 4;
    }
}
