package May2020;

public class Day8_CheckIfItIsStraightLine {
    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 6}
        }));

        System.out.println(checkStraightLine(new int[][]{
                {1, 1},
                {2, 2},
                {3, 4},
                {4, 5},
                {5, 6},
                {7, 7}
        }));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;

        double ratio = getRatio(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);

        for (int i = 2; i < coordinates.length; i++) {
            double diff = Math.abs(ratio - getRatio(coordinates[i - 1][0], coordinates[i - 1][1], coordinates[i][0], coordinates[i][1]));
            if (diff > 0.05) return false;
        }

        return true;
    }

    private static double getRatio(int x1, int y1, int x2, int y2) {
        return (y1 == y2) ? 0d : (float) Math.abs(x1 - x2) / (float) Math.abs(y1 - y2);
    }
}
