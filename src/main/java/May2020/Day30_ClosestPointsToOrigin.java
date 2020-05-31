package May2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day30_ClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] closestPoints = kClosest(new int[][]{
                {-2, 2},
                {1, 3}
        }, 1);
        for (int[] point : closestPoints) System.out.println(Arrays.toString(point));

        closestPoints = kClosest(new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4}
        }, 2);
        for (int[] point : closestPoints) System.out.println(Arrays.toString(point));
    }

    public static int[][] kClosest(int[][] points, int K) {
        List<Distance> distances = new ArrayList<>();
        for (int[] point : points) distances.add(new Distance(point));
        distances.sort(Comparator.comparingDouble(d -> d.distance));

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) result[i] = distances.get(i).point;

        return result;
    }

    private static class Distance {
        Double distance;
        int[] point;

        public Distance(int[] point) {
            this.distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            this.point = point;
        }
    }
}
